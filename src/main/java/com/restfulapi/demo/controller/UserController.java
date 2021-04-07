package com.restfulapi.demo.controller;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController
{
    @Operation(description = "跳转注册用户")
    @GetMapping("/user")
    public String toAddUser(Model model)
    {
        return "admin/user/add";
    }

    @Operation(description = "注册用户")
    @PostMapping("/user/{name}/{password}/{role}")
    public String addUser(@PathVariable String name, @PathVariable String password, @PathVariable String role)
    {
        return "redirect:/admin/";
    }
}