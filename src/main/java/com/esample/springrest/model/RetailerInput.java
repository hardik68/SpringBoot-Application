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
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getIfscCode() {
        return IfscCode;
    }

    public void setIfscCode(String ifscCode) {
        IfscCode = ifscCode;
    }

    String panNumber;

    String aadharNumber;

    String AccountNumber;

    String gstNumber;

    String IfscCode;

    public String getConfirmAccountNumber() {
        return ConfirmAccountNumber;
    }

    public void setConfirmAccountNumber(String confirmAccountNumber) {
        ConfirmAccountNumber = confirmAccountNumber;
    }

    String ConfirmAccountNumber;


}
