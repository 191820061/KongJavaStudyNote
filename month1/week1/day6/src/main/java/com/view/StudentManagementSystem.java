package com.view;

import com.controller.StudentController;

import java.util.Scanner;

public class StudentManagementSystem {
    private final StudentController controller;

    public StudentManagementSystem(String path) {
        this.controller = new StudentController(path);
    }


    public void start() {
        printMenu();
        Scanner s = new Scanner(System.in);

    }

    private void printMenu() {
        System.out.println("*******************");
        System.out.println("*      0>退出      *");
        System.out.println("*      1>帮助      *");
        System.out.println("*      2>查看      *");
        System.out.println("*      3>添加      *");
        System.out.println("*      4>修改      *");
        System.out.println("*      5>删除      *");
        System.out.println("*******************");
    }
}
