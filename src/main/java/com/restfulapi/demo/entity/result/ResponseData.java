package com.restfulapi.demo.entity.result;

import com.fasterxml.jackson.annotation.JsonView;
import com.restfulapi.demo.dao.Views;

import java.util.List;

public class ResponseData extends Response
{
    private Object data;
    public ResponseData(Object data)
    {
        super();
        this.data=data;
    }
    public ResponseData(ExceptionMsg msg,Object data)
    {
        super(msg);
        this.data=data;
    }
    @JsonView(Views.Public.class)
    public Object getData()
    {
        return data;
    }
}