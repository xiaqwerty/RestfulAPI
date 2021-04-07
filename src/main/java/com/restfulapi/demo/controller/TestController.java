package com.restfulapi.demo.controller;

import com.restfulapi.demo.entity.User;
import com.restfulapi.demo.entity.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
/*
Just for test
使用RestClient测试
*/
@RestController

public class TestController
{
    @Operation(description = "Just for Test")
    @RequestMapping("/test-DefaultException")
    public String testResponseStatusExceptionResolver()
    {
        throw new BusinessException(600,"自定义业务错误");
    }

    @Operation(description = "Just for Test")
    @GetMapping("/test-getparameter")
    public User getparameter(User user)
    {
        return user;
    }

    @Operation(description = "Just for Test")
    @GetMapping("/test-getuser")
    public User user1()
    {
        return new User(1,"myUser");
    }

    @Operation(description = "Just for Test")
    @PostMapping("/test-postuser")
    public User postUser(User user)
    {
        System.out.println(user.toString());
        System.out.println("name:"+user.getName());
        System.out.println("id:"+user.getId());
        return user;
    }

    @Operation(description = "Just for Test")
    @PutMapping("/test-putuser")
    public void putUser(@RequestBody User user)
    {
        System.out.println(user.toString());
    }

    @Operation(description = "Just for Test")
    @DeleteMapping("/test-deleteuser")
    public void deleteUser(Long id)
    {
        System.out.println(id);
    }

    /*使用@schema中的allowableValues*/
    @Operation(description = "Just for Test")
    @GetMapping("/test-schema")
    public Object example(@Parameter(name ="json", schema = @Schema(description = "var 1",type = "string", allowableValues = {"1", "2"}))
                                  String json) {
        return null;
    }
}
