package com.example.todobackend.database.repository;

import com.example.todobackend.database.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    TodoList getById(long id);

    TodoList deleteById(long id);
}
