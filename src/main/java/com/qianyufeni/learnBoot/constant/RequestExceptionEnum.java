package com.qianyufeni.learnBoot.constant;

/**
 * 自定义异常码和异常信息
 */
public enum RequestExceptionEnum {
    BASE("1001","服务器内部错误"),
    USER_NOT_FOUND("2001","用户不存在");
    private String code;
    private String message;

    RequestExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
