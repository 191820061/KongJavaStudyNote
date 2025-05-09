package com.example;

import java.util.Scanner;

public class StringTraverse {
    public static void main(String[] args) {
        String input;
        try (Scanner s = new Scanner(System.in)){
            input = s.next();
            for (char c:input.toCharArray()){
                System.out.println(c);
            }
        }
    }
}
