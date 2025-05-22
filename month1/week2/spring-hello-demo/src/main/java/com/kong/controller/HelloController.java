package com.kong.controller;

import com.kong.model.User;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/info")
    public String getMessage(@ModelAttribute User user) {
        return user.getName() + ' ' + user.getAge() + ' ' + user.getPhone() + ' ' + user.getAddress();
    }

    @RequestMapping("/listParameter")
    public String getHobby(@RequestParam(value = "hobby") List<String> myHobby) {
        return myHobby.toString();
    }

    @RequestMapping("/user/{id}")
    public String getUserId(@PathVariable Integer id) {
        if (id != null) {
            return "you id is " + id;
        }
        return "404";
    }

    @RequestMapping("/objectResponse")
    public User getUser(){
        return new User("郝文乾", 23,"安徽","13965358064");
    }
}
