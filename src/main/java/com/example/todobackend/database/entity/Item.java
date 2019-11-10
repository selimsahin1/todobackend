package com.example.todobackend.database.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "deadLine")
    private Date deadLine;
    @Column(name = "status")
    private Integer status;
    @ManyToOne
    private Todo todo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    private Date convertStringToDate(String date) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date out = null;
        try {
            out = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return out;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = convertStringToDate(deadLine);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}
