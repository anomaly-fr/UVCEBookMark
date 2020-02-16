package com.example.uvcebookmark;

public class User {
    String Name, Contact, RegisterNumber,Password;

    public User() {
        //Empty Constructor for Firestore
    }

    public User(String name, String contact, String registerNumber, String password) {
        Name = name;
        Contact = contact;
        RegisterNumber = registerNumber;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        RegisterNumber = registerNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
