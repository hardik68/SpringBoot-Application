package com.esample.springrest.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="user_name")
    private String userName;
    @Column(name="phone_no")
    private String phoneNum;
    @Column(name="is_approver")
    private boolean isApprover;
    @Column(name="store_name")
    private String storeName;
    @Column(name="is_retailer")
    private boolean isRetailer;
    @Column(name="user_password")
    private String userPassword;
    @Column(name="userverified")
    private boolean userverified;


    @Column(name = "Userverified")
    public boolean Userverified() {
        return userverified;
    }

    public boolean isApprover() {
        return isApprover;
    }

    public void setApprover(boolean approver) {
        isApprover = approver;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public boolean isUserverified() {
        return userverified;
    }




    public void setUserverified(boolean userverified) {
        this.userverified = userverified;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
