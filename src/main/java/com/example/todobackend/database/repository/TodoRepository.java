package com.example.todobackend.database.repository;

import com.example.todobackend.database.entity.Todo;
import com.example.todobackend.database.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo getById(long id);

    List<Todo> findAllByTodoList(TodoList todoList);


    List<Todo> deleteByTodoList(TodoList todoList);

}
