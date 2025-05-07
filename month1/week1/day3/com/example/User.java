package com.example;

//JavaBean类
public class User {
    private String userName;
    private String password;
    private String email;
    private String gender;
    private int age;

    public User() {
    }

    public User(String userName, String password, String email, String gender, int age) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
