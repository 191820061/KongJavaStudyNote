package com.model;

import com.opencsv.bean.CsvBindByName;


//学生类，学生数据模型
public class Student {
    @CsvBindByName(column = "ID")
    private String studentId;    //学号
    @CsvBindByName(column = "Name")
    private String name;         //姓名
    @CsvBindByName(column = "Gender")
    private String gender;       //性别
    @CsvBindByName(column = "Age")
    private int age;             //年龄
    @CsvBindByName(column = "Phone")
    private String phoneNumber;  //联系电话
    @CsvBindByName(column = "Address")
    private String homeAddress;  //家庭住址
    @CsvBindByName(column = "Description")
    private String description;  //学生描述

    public Student() {

    }

    public Student(String studentId, String name, String gender, int age, String phoneNumber, String homeAddress, String description) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student s = (Student) obj;
        return this.studentId.equals(s.studentId);
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
