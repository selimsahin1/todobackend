package com.example.todobackend.controller;

import com.example.todobackend.database.entity.TodoList;
import com.example.todobackend.database.entity.User;
import com.example.todobackend.database.repository.TodoListRepository;
import com.example.todobackend.database.repository.UserRepository;
import com.example.todobackend.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/todoList")
public class TodoListController {

    @Autowired
    TodoListRepository todoListRepository;

    @Autowired
    private UserManager userManager;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/createTodoList")
    public TodoList createTodoList(@RequestParam("todoListName") String todoListName) {
        User user = userManager.getUserFromSecurityContext();
        TodoList todoList = new TodoList();
        todoList.setName(todoListName);
        todoList.setUser(user);
        todoListRepository.save(todoList);

        return todoList;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getAllTodoLists")
    public Collection<TodoList> getTodoLists() {
        return todoListRepository.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(value = "/deleteTodoList/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        todoListRepository.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
