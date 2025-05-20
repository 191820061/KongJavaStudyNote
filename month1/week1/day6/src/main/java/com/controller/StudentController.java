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
            this.finalPath = path;
            System.out.println("正在使用数据文件" + path);
        }
    }

    public void saveToFile() {
        boolean success = this.manager.storeToFile(finalPath);
        if (!success) {
            System.err.println("保存失败!!!");
        } else {
            System.out.println("保存成功。");
        }
    }

    public void showAllStudents() {
        List<Student> allStudents = this.manager.getAllStudent();
        if (allStudents.isEmpty()) {
            System.out.println("数据为空");
        } else {
            for (Student s : allStudents) {
                printStudent(s);
            }
        }
    }

    public void deleteById(String id) {
        boolean success = this.manager.removeStudentById(id);
        if (!success) {
            System.err.println("删除失败");
        } else {
            System.out.println("删除成功!");
        }
    }

    public void add(Student s) {
        boolean success = this.manager.addStudent(s);
        if (!success) {
            System.err.println("不可以添加重复学号数据！！！");
        }
    }

    public void searchById(String id) {
        Student res = this.manager.getStudentById(id);
        if (res == null) {
            System.err.println("没有该学号同学数据。");
        } else {
            printStudent(res);
        }
    }

    public void searchByName(String name) {
        List<Student> res = this.manager.getStudentByName(name);
        if (res.isEmpty()) {
            System.err.println("没有该姓名同学数据。");
        } else {
            for (Student s : res) {
                printStudent(s);
            }
        }
    }

    public void printStudent(Student s) {
        if (s == null) {
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
