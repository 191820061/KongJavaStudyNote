package com.example;

import java.util.Scanner;

public class StringCount {
    //字符串统计功能实现
    public static void stringCountFunction(String input) {
        int lowerCaseCount = 0;
        int upperCaseCount = 0;
        int digitCount = 0;
        int otherCount = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCaseCount++;
            } else if (Character.isUpperCase(c)) {
                upperCaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("你输入的字符串中一共有" + input.length() + "个字符，其中");
        System.out.println("小写字母字符: " + lowerCaseCount);
        System.out.println("大写字母字符: " + upperCaseCount);
        System.out.println("数字字符: " + digitCount);
        System.out.println("其他字符: " + otherCount);
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("请输入你要统计的字符串: ");
            String input = s.nextLine();
            stringCountFunction(input);
        }
    }
}
