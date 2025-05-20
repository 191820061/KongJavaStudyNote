package com.view;

import com.controller.StudentController;
import com.model.Student;

import java.util.Scanner;

public class StudentManagementSystem {
    public static final int EXIT = 0;
    public static final int HELP = 1;
    public static final int SEARCH = 2;
    public static final int ADD = 3;
    public static final int SET = 4;
    public static final int DELETE = 5;
    public static final int SHOW = 6;
    public static final int SAVE = 7;
    private final StudentController controller;
    private final Scanner s;

    public StudentManagementSystem(String path) {
        this.controller = new StudentController(path);
        this.s = new Scanner(System.in)
        ;
    }


    public void start() {
        printMenu();
        System.out.println("请输入你的选择(对应数字)>");
        int op = 0;
        while (true) {
            op = getNextIntToken();
            if (op < 0 || op > 7) {
                System.err.println("请输入正确的数字");
                continue;
            }
            switch (op) {
                case EXIT:
                    exit();
                    break;
                case HELP:
                    help();
                    break;
                case SEARCH:
                    search();
                    break;
                case ADD:
                    add();
                    break;
                case SET:
                    set();
                    break;
                case DELETE:
                    delete();
                    break;
                case SHOW:
                    show();
                    break;
                case SAVE:
                    save();
                    break;
                default:
                    System.err.println("????!!!!");
            }
            System.out.println("请输入你的选择(对应数字)>");
        }
    }

    public void save() {
        this.controller.saveToFile();
    }

    public void show() {
        this.controller.showAllStudents();
    }

    public void delete() {
        System.out.println("请输入要删除学生的ID>");
        this.controller.deleteById(getNextToken());
    }

    //暂时通过删除后添加实现，以后再修改。
    public void set() {
        System.out.println("请输入要修改学生的ID>");
        this.controller.deleteById(getNextToken());
        System.out.println("请输入修改后学生的信息。");
        add();
    }

    //添加
    public void add() {
        Student s = new Student();
        System.out.println("请输入学号>");
        String id = getNextToken();
        if (id.length() != 5) {
            System.out.println("无法添加!!!");
            return;
        }
        s.setStudentId(id);
        System.out.println("请输入姓名");
        s.setName(getNextToken());
        System.out.println("请输入性别");
        s.setGender(getNextToken());
        System.out.println("请输入年龄");
        int age = getNextIntToken();
        if (age < 0 || age > 100) {
            System.err.println("无法添加!!!");
            return;
        }
        s.setAge(age);
        System.out.println("请输入联系电话>");
        s.setPhoneNumber(getNextToken());
        System.out.println("请输入家庭住址>");
        s.setHomeAddress(getNextToken());
        System.out.println("请输入学生评价>");
        s.setDescription(getNextToken());
        this.controller.add(s);
    }

    //通过学号或者姓名搜索。
    public void search() {
        System.out.println("姓名或学号？(输入“姓名”或者“学号”)");
        String selection = getNextToken();
        if (selection.equals("姓名")) {
            System.out.println("请输入姓名>");
            String name = getNextToken();
            this.controller.searchByName(name);
        } else if (selection.equals("学号")) {
            System.out.println("请输入学号>");
            String id = getNextToken();
            this.controller.searchById(id);
        } else {
            System.err.println("错误输入，请输入“学号”或者“姓名”");
        }
    }

    public void help() {
        System.out.println("输入0，程序结束。");
        System.out.println("输入1，打印程序使用手册。");
        System.out.println("输入2，输入姓名或者学号，搜索对应的信息。");
        System.out.println("输入3，添加学生信息。");
        System.out.println("输入4，输入学号，修改指定的信息。");
        System.out.println("输入5，输入学号，删除对应的信息。");
        System.out.println("输入6，查看全部信息。");
        System.out.println("输入7，将数据保存到打开文件中。");
    }

    public void exit() {
        System.out.println("是否要将数据保存到文件中?(输入“Yes”进行保存)>");
        String input = getNextToken();
        if (input.equals("Yes")) {
            save();
        }
        System.exit(0);
    }

    private void printMenu() {
        System.out.println("*******************");
        System.out.println("*      0>退出      *");
        System.out.println("*      1>帮助      *");
        System.out.println("*      2>搜索      *");
        System.out.println("*      3>添加      *");
        System.out.println("*      4>修改      *");
        System.out.println("*      5>删除      *");
        System.out.println("*      6>查看      *");
        System.out.println("*      7>保存      *");
        System.out.println("*******************");
    }

    public String getNextToken() {
        return s.nextLine().trim().split("\\s+")[0];
    }

    public int getNextIntToken() {
        try {
            return Integer.parseInt(getNextToken());
        } catch (NumberFormatException e) {
            System.err.println("请输入数字");
            return -1;
        }
    }
}
