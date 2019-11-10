package com.example.todobackend.database.entity;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "todolist")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "todoList", orphanRemoval = true)
    private Collection<Todo> todos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Collection<Todo> todos) {
        this.todos = todos;
    }
}
