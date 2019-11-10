package com.example.todobackend.database.repository;

import com.example.todobackend.database.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo getById(long id);

}
