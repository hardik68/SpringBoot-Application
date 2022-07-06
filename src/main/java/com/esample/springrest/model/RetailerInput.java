package com.esample.springrest.model;

public class RetailerInput {

    String first_name;

    String last_name;

    String email;
    String mobile_number;
    String adharcardNo;
    String panNo;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getAdharcardNo() {
        return adharcardNo;
    }

    public void setAdharcardNo(String adharcardNo) {
        this.adharcardNo = adharcardNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }
}
