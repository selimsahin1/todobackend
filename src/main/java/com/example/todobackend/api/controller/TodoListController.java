package com.example.todobackend.api.controller;

import com.example.todobackend.database.entity.TodoList;
import com.example.todobackend.database.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/todoList")
public class TodoListController {

    @Autowired
    TodoListRepository todoListRepository;

    @PostMapping("/createTodoList")
    public TodoList createTodoList(@RequestParam("todoListName") String todoListName) {
        TodoList todoList = new TodoList();
        todoList.setName(todoListName);
        todoListRepository.save(todoList);

        return todoList;
    }

    @GetMapping("/getAllTodoLists")
    public Collection<TodoList> getTodoLists() {
        return todoListRepository.findAll();
    }

    @DeleteMapping(value = "/deleteTodoList/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        todoListRepository.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
