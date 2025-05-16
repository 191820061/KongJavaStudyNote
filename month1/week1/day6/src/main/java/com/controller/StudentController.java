package com.controller;

import com.model.StudentManager;

import java.io.File;

public class StudentController {
    private final StudentManager manager;
    //默认数据文件设置
    private final String defaultPath = "data/students.csv";


    public StudentController(String path) {
        File file = new File(path);
        if (!file.exists()) {
            this.manager = new StudentManager(defaultPath);
        } else {
            this.manager = new StudentManager(path);
        }
    }
}
