package com.esample.springrest.model;

public class EmailInput {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmailInput(String email) {
        this.email = email;
    }

    String email;

    public EmailInput() {
    }
}
