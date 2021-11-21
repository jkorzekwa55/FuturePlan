package com.example.futureplan;

public class UserModel {
    private int id;
    private String firstName;
    private String secondName;
    private String name;
    private String email;
    private String password;
    private String number;
    private String date;

    public UserModel(int id, String name, String email, String password ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UserModel(int id, String firstName, String secondName,String name, String email, String password, String number, String date){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
        this.date = date;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserModel() {
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
