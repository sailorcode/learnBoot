package com.qianyufeni.learnBoot.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = 7957776767061701385L;
    private String code;
    //Http状态码,默认500,这里的状态码会被BaseErrorController.error()获取并设置成httpResponse的状态码
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public BadRequestException(String code,String message) {
        super(message);
        this.code = code;
    }
    public BadRequestException(String code,String message,HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }
    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
