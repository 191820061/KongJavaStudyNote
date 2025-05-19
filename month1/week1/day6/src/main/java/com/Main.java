package com;

import com.view.StudentManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("系统启动.....................");
        System.out.println("请输入数据存储文件路径。");
        String path = s.nextLine().trim().split("\\s+")[0];
        StudentManagementSystem system = new StudentManagementSystem(path);
        system.start();
    }
}
