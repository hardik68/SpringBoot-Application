package com.esample.springrest.response;

public class KycResponse {
    int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String status;
    String message;

    public KycResponse(String status,String message){
        this.message=message;
        this.status=status;
    }
}
