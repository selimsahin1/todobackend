package com.example.todobackend.database.repository;

import com.example.todobackend.database.entity.TodoList;
import com.example.todobackend.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    TodoList getById(long id);

    List<TodoList> findAll();

    List<TodoList> findAllByUser(User user);

    void deleteByUserAndId(User user,Long id);
}
