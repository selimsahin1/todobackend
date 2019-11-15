package com.example.todobackend.Request;

public class ChangeStatusRequest {

    private Long todoId;
    private String status;

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
