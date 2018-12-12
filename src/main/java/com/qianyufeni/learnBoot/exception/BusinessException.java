package com.qianyufeni.learnBoot.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 1837124035377973637L;
    private String code;

    public BusinessException(String code,String message) {
        super(message);
        this.code = code;
    }
    public BusinessException(String code,String message,HttpStatus status) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}