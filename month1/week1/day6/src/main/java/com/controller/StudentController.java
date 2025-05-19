package com.controller;

import com.model.Student;
import com.model.StudentManager;

import java.io.File;
import java.util.List;

public class StudentController {
    private final StudentManager manager;
    //默认数据文件设置
    private final String defaultPath = "data/students.csv";
    private final String finalPath;


    public StudentController(String path) {
        File file = new File(path);
        if (!file.exists()) {
            this.manager = new StudentManager(defaultPath);
            this.finalPath = defaultPath;
            System.out.println("正在使用默认数据文件" + defaultPath);
        } else {
            this.manager = new StudentManager(path);
            this.finalPath=path;
            System.out.println("正在使用数据文件" + path);
        }
    }

    public void add(Student s){
        boolean success = this.manager.addStudent(s);
        if (!success){
            System.err.println("不可以添加重复学号数据！！！");
        }
    }
    public void searchById(String id){
        Student res = this.manager.getStudentById(id);
        printStudent(res);
    }
    public void searchByName(String name){
        List<Student> res = this.manager.getStudentByName(name);
        for (Student s:res){
            printStudent(s);
        }
    }
    public void printStudent(Student s){
        if (s==null){
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(s.getStudentId()).append(" ");
        builder.append(s.getName()).append(" ");
        builder.append(s.getGender()).append(" ");
        builder.append(s.getAge()).append(" ");
        builder.append(s.getPhoneNumber()).append(" ");
        builder.append(s.getHomeAddress()).append(" ");
        builder.append(s.getDescription());
        System.out.println(builder);
    }
}
