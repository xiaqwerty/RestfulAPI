package com.restfulapi.demo.controller;

import com.restfulapi.demo.entity.exception.BusinessException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@RestControllerAdvice
public class GlobalExceptionHandler
{
    //日志记录工具
    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 400-Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Map<String,Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e)
    {
        logger.error("缺少请求参数",e);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",400);
        map.put("message",e.getMessage());
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 400-Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e)
    {
        logger.error("缺少请求参数",e);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",400);
        map.put("message",e.getMessage());
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 400-Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        logger.error("参数验证失败",e);
        BindingResult result=e.getBindingResult();
        FieldError error=result.getFieldError();
        String field=error.getField();
        String code=error.getDefaultMessage();
        String message=String.format("%s:%s",field,code);
        Map<String,Object> map=new HashMap<>();
        map.put("code",code);
        map.put("message",message);
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 400-Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Map<String,Object> handleBindException(BindException e)
    {
        logger.error("缺少请求参数",e);
        BindingResult result=e.getBindingResult();
        FieldError error=result.getFieldError();
        String field=error.getField();
        String code=error.getDefaultMessage();
        String message=String.format("%s:%s",field,code);
        Map<String,Object> map=new HashMap<>();
        map.put("code",400);
        map.put("message",message);
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 400-Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,Object> handleServiceException(javax.validation.ConstraintViolationException e)
    {
        logger.error("缺少请求参数",e);
        Set<ConstraintViolation<?>> violations=e.getConstraintViolations();
        ConstraintViolation<?> violation=violations.iterator().next();
        String message=violation.getMessage();
        Map<String,Object> map=new HashMap<>();
        map.put("code",400);
        map.put("message",message);
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 400-Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Map<String,Object> handleValidationException(ValidationException e)
    {
        logger.error("参数验证失败",e);
        Map<String,Object> map=new HashMap<>();
        map.put("code",400);
        map.put("message",e.getMessage());
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 405-Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String,Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e)
    {
        logger.error("不支持当前请求方法",e);
        Map<String,Object> map=new HashMap<>();
        map.put("code",400);
        map.put("message",e.getMessage());
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 415-Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String,Object> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e)
    {
        logger.error("不支持当前媒体类型",e);
        Map<String,Object> map=new HashMap<>();
        map.put("code",415);
        map.put("message",e.getMessage());
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 自定义异常类
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Map<String,Object> handleBusinessException(BusinessException e)
    {
        logger.error("自定义异常抛出",e);
        Map<String,Object> map=new HashMap<>();
        map.put("code",e.getCode());
        map.put("message",e.getMessage());
        //map用于写入数据库或者其他处理
        return map;
    }
    /**
     * 获取其他异常，包括500
     */
    @ExceptionHandler(value=Exception.class)
    public Map<String,Object> defaultErrorHandler(Exception e)
    {
        logger.error("其他异常抛出",e);
        Map<String,Object> map=new HashMap<>();
        map.put("code",500);
        map.put("message",e.getMessage());
        //map用于写入数据库或者其他处理
        return map;
    }
}

