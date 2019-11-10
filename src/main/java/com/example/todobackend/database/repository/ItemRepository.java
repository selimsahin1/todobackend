package com.example.todobackend.database.repository;

import com.example.todobackend.database.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item getById(long id);

}
