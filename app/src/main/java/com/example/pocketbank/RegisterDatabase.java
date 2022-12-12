package com.example.pocketbank;

public class RegisterDatabase {
    String NewUser;
    String Password;
    String Name;

    public String getNewUser() {
        return NewUser;
    }

    public void setNewUser(String newUser) {
        NewUser = newUser;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public RegisterDatabase(String newUser, String password, String name, String emailId, String phoneNumber) {
        NewUser = newUser;
        Password = password;
        Name = name;
        EmailId = emailId;
        PhoneNumber = phoneNumber;
    }

    String EmailId;
    String PhoneNumber;
    //HAVE TO ADD CHECKBOX DETAILS

}
