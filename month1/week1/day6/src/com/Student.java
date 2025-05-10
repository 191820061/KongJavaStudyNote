package com;

//学生类，学生数据模型
public class Student {
    private String studentId;    //学号
    private String name;         //姓名
    private String gender;       //性别
    private int age;             //年龄
    private String phoneNumber;  //联系电话
    private String homeAddress;  //家庭住址
    private String description;  //学生描述

    public Student() {

    }

    public Student(
            String studentId,
            String name,
            String gender,
            int age,
            String phoneNumber,
            String homeAddress,
            String description
    ) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.description = description;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
