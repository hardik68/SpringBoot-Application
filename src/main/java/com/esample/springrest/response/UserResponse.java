package com.esample.springrest.response;

public class UserResponse {

    int id;
    String message;
    String status;

    public UserResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public UserResponse(int id, String message, String status) {
        this.id = id;
        this.message = message;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
