package com.example.todobackend.database.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String Name;
    @ManyToOne
    private TodoList todoList;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "todo", orphanRemoval = true)
    private Collection<Item> items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}
