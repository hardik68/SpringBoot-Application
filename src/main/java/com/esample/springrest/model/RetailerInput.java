package com.esample.springrest.model;

public class RetailerInput {

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    String panNumber;

    String aadharNumber;
    String accountNumber;

    String gstNumber;

    String ifscCode;
    String confirmAccountNumber;

    public String getConfirmAccountNumber() {
        return confirmAccountNumber;
    }

    public void setConfirmAccountNumber(String confirmAccountNumber) {
        this.confirmAccountNumber = confirmAccountNumber;
    }
}
