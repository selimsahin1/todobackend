package com.example.todobackend.controller;

import com.example.todobackend.database.entity.Item;
import com.example.todobackend.database.entity.Todo;
import com.example.todobackend.database.repository.ItemRepository;
import com.example.todobackend.database.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    TodoRepository todoRepository;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/createItem")
    public Item createNewItem(@RequestParam("itemName") String itemName, @RequestParam("todoId") long todoId) {

        Todo todo = todoRepository.getById(todoId);

        Item item = new Item();
        item.setName(itemName);
        item.setTodo(todo);
        itemRepository.save(item);
        return item;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/editItem")
    public Item editItem(@RequestParam("itemId") long itemId, @RequestParam("itemDescription") String itemDescription, @RequestParam("itemDeadLine") String itemDeadLine, @RequestParam("itemStatus") Integer itemStatus) {
        Item item = itemRepository.getById(itemId);
        item.setDeadLine(itemDeadLine);
        item.setDescription(itemDescription);
        item.setStatus(itemStatus);
        itemRepository.save(item);
        return item;
    }

    @GetMapping("/getAllItems")
    public Collection<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
