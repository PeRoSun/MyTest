package com.example.demo.exception;


import lombok.Getter;

/**
 * 自定义异常
 */

@Getter
public class ServiceException extends RuntimeException{//RuntimeException => java自带
    private String code;

    public ServiceException(String code,String msg){
        super(msg);
        this.code = code;
    }
}
