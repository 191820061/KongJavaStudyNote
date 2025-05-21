package com.kong.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("有人正在请求hello。");
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" ");
        if (age != null) {
            builder.append(age);
        }
        return builder.toString();
    }
}
