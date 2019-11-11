package com.example.todobackend.controller;

import com.example.todobackend.database.entity.Todo;
import com.example.todobackend.database.entity.TodoList;
import com.example.todobackend.database.repository.TodoListRepository;
import com.example.todobackend.database.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoListRepository todoListRepository;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/createTodo")
    public Todo createTodo(@RequestParam("todoName") String todoName, @RequestParam("todoListId") long todoListId) {

        TodoList todoList = todoListRepository.getById(todoListId);

        Todo todo = new Todo();
        todo.setName(todoName);
//        todo.setTodoList(todoList);
        todoRepository.save(todo);

        return todo;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getAllTodos")
    public Collection<Todo> getTodoLists() {
        return todoRepository.findAll();
    }

}