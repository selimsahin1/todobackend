package com.example.todobackend.controller;

import com.example.todobackend.Request.CreateTodoListRequest;
import com.example.todobackend.Request.DeleteTodoListRequest;
import com.example.todobackend.database.entity.Todo;
import com.example.todobackend.database.entity.TodoList;
import com.example.todobackend.database.entity.User;
import com.example.todobackend.database.repository.TodoListRepository;
import com.example.todobackend.database.repository.TodoRepository;
import com.example.todobackend.database.repository.UserRepository;
import com.example.todobackend.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/todoList")
public class TodoListController {

    @Autowired
    TodoListRepository todoListRepository;

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    private UserManager userManager;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/createTodoList")
    public String createTodoList(@RequestBody CreateTodoListRequest createTodoListRequest) {
        User user = userManager.getUserFromSecurityContext();
        TodoList todoList = new TodoList();
        todoList.setName(createTodoListRequest.getTodoListName());
        todoList.setUser(user);

        if (createTodoListRequest.getTodoListName() == null || createTodoListRequest.getTodoListName().equals(""))
            return "Send todo list name";
        else
            todoListRepository.save(todoList);

        return "TodoList Created";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getAllTodoLists")
    public List<TodoList> getTodoLists() {
        User user = userManager.getUserFromSecurityContext();

        return todoListRepository.findAllByUser(user);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = "/deleteTodoList")
    public ResponseEntity<Long> deletePost(@RequestBody DeleteTodoListRequest deleteTodoListRequest) {

        TodoList todoList = todoListRepository.getById(deleteTodoListRequest.getTodoListId());

        List<Todo> todos = todoRepository.findAllByTodoList(todoList);

        for (Todo todo : todos
        ) {
            todoRepository.delete(todo);
        }

        todoListRepository.delete(todoList);

        return new ResponseEntity<>(deleteTodoListRequest.getTodoListId(), HttpStatus.OK);
    }

}
