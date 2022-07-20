package com.esample.springrest.entities;

import javax.persistence.*;

@Entity
@Table(name = "retailer_user1")
public class RetailerUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "aadhar_card")
    private String aadharNumber;

    @Column(name = "pan_card")
    private String panNumber;
    @Column(name = "Ifsc_code")
    private String IfscCode;
    @Column(name = "gst")
    private String gst;
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "confirm_account")
    private String confirmAccountNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getIfscCode() {
        return IfscCode;
    }

    public void setIfscCode(String ifscCode) {
        IfscCode = ifscCode;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getConfirmAccountNumber() {
        return confirmAccountNumber;
    }

    public void setConfirmAccountNumber(String confirmAccountNumber) {
        this.confirmAccountNumber = confirmAccountNumber;
    }
}





