package com.example;

import java.util.Scanner;

public class Login {
    public final static int MAX_INPUT = 3;
    public static void main(String[] args) {
        String userName = "kongbai";
        String password = "2001qweQWE";
        int count = 0;
        try (Scanner s = new Scanner((System.in))) {
            while (true) {
                System.out.print("请输入您的用户名: ");
                String inputUserName = s.next();
                System.out.print("请输入您的密码: ");
                String inputPassword = s.next();
                count++;
                if (checkLogin(userName, password, inputUserName, inputPassword)) {
                    System.out.println("登陆成功。");
                    break;
                } else {
                    System.out.println("您的用户名或密码输入错误。");
                    if (count >= MAX_INPUT) {
                        System.out.println("您尝试的次数过多，请等待1分钟后再输入。");
                        break;
                    } else {
                        System.out.println("您还有" + (MAX_INPUT - count) + "次尝试机会。");
                    }
                }
            }
        }
    }

    public static boolean checkLogin(String correctName, String correctPassword, String inputUserName, String inputPassword) {
        return correctPassword.equals(inputPassword) && correctName.equals(inputUserName);
    }
}
