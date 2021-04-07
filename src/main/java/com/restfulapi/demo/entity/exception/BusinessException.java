package com.restfulapi.demo.entity.exception;

public class BusinessException extends RuntimeException
{
    private Integer code;
    private String message;
    public BusinessException(Integer code,String message)
    {
        super(message);
        this.code=code;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }
}
