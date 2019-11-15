package com.example.todobackend.Request;


public class TodoRequest {

    private String name;
    private String description;
    private String deadLine;
    private String createTime;
    private String status;
    private Long todoListId;
    private Long relatedTodoId;

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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Long todoListId) {
        this.todoListId = todoListId;
    }

    public Long getRelatedTodoId() {
        return relatedTodoId;
    }

    public void setRelatedTodoId(Long relatedTodoId) {
        this.relatedTodoId = relatedTodoId;
    }
}
