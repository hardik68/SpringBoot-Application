package com.esample.springrest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInputRequest {

   private String name;
    private String phone;
    private  String email;
    @JsonProperty("user_name")
    private  String userName;
    @JsonProperty("store_name")
    private  String storeName;
    @JsonProperty("is_approver")
    private boolean isApprover;
    @JsonProperty("is_retailer")
    private boolean isRetailer;
    @JsonProperty("user_password")
    private String userPassword;
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isApprover() {
        return isApprover;
    }

    public void setApprover(boolean approver) {
        isApprover = approver;
    }

    public boolean isRetailer() {
        return isRetailer;
    }

    public void setRetailer(boolean retailer) {
        isRetailer = retailer;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
