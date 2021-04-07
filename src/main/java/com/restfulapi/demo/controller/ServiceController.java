package com.restfulapi.demo.controller;

import com.restfulapi.demo.entity.Subscribe;
import com.restfulapi.demo.entity.result.ExceptionMsg;
import com.restfulapi.demo.entity.result.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController
{
    @GetMapping("/subscribe")
    public ResponseData subscribe()
    {
        Subscribe subscribe=new Subscribe();
        return new ResponseData(ExceptionMsg.SUCCESS,subscribe);
    }
}
