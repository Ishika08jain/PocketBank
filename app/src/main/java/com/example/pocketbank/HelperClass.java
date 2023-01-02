package com.example.pocketbank;

public class HelperClass {
    String FullName, Password, userid, EmailId, PhoneNumber;
    public HelperClass(String fullName, String password, String userid, String emailId, String phoneNumber) {
        FullName = fullName;
        Password = password;
        this.userid = userid;
        EmailId = emailId;
        PhoneNumber = phoneNumber;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    public HelperClass() {
    }


}