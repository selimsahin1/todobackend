package com.example.todobackend.controller;

import com.example.todobackend.Request.ChangeStatusRequest;
import com.example.todobackend.Request.DeleteTodoListRequest;
import com.example.todobackend.Request.DeleteTodoRequest;
import com.example.todobackend.Request.TodoRequest;
import com.example.todobackend.database.entity.Todo;
import com.example.todobackend.database.entity.TodoList;
import com.example.todobackend.database.repository.TodoListRepository;
import com.example.todobackend.database.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoListRepository todoListRepository;


    @PreAuthorize("hasRole('USER')")
    @PostMapping("/createTodo")
    public String createTodo(@Valid @RequestBody TodoRequest todoRequest) throws ParseException {

        TodoList todoList = todoListRepository.getById(todoRequest.getTodoListId());
        long epoch = System.currentTimeMillis() / 1000;
        Todo relatedTodo = null;
        if (todoRequest.getRelatedTodoId() != null)
            relatedTodo = todoRepository.getById(todoRequest.getRelatedTodoId());
        Todo todo = new Todo();

        long endEpoch = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(todoRequest.getDeadLine()).getTime() / 1000;
        todo.setName(todoRequest.getName());
        todo.setDeadLine(String.valueOf(endEpoch));
        todo.setTodoList(todoList);
        todo.setCreateTime(String.valueOf(epoch));
        todo.setRelatedTodos(relatedTodo);
        todo.setDescription(todoRequest.getDescription());
        todo.setStatus("task");
        todoRepository.save(todo);

        return "Todo Created";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getAllTodos")
    public Collection<Todo> getTodoLists(@RequestParam("todoListId") Long todoListId) {

        TodoList todoList = todoListRepository.getById(todoListId);

        return todoRepository.findAllByTodoList(todoList);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/changeStatus")
    public String changeStatus(@Valid @RequestBody ChangeStatusRequest changeStatusRequest) {

        Todo todo = todoRepository.getById(changeStatusRequest.getTodoId());

        todo.setStatus(changeStatusRequest.getStatus());

        todoRepository.save(todo);

        return "Status changed";
    }

}
