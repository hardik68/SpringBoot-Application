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

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="gst")
    private String gst;
    @Column(name="address")
    private String  address;

    @Column(name = "Userverified")
    public boolean Userverified() {
        return userverified;
    }

    public void setUserverified(boolean userverified) {
        this.userverified = userverified;
    }

    @Column(name="userverified")
    private boolean userverified;



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
