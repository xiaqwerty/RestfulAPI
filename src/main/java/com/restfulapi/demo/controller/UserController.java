package com.restfulapi.demo.controller;
import com.fasterxml.jackson.annotation.JsonView;
import com.restfulapi.demo.dao.UserRepository;
import com.restfulapi.demo.dao.Views;
import com.restfulapi.demo.entity.User;
import com.restfulapi.demo.entity.result.ExceptionMsg;
import com.restfulapi.demo.entity.result.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @Operation(description = "展示所有用户")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @JsonView(Views.Public.class)
    public ResponseData getUserList()
    {
        User user=new User(-1,"default","123456");
        userRepository.save(user);
        return new ResponseData(ExceptionMsg.SUCCESS,userRepository.findAll());
    }

    @Operation(description = "注册用户")
    @RequestMapping(value = "/{name}/{password}",method = RequestMethod.POST)
    public ResponseData addUser(@PathVariable String name, @PathVariable String password)
    {
        User user=new User(name,password);
        userRepository.save(user);
        return new ResponseData(ExceptionMsg.SUCCESS,user);
    }
}