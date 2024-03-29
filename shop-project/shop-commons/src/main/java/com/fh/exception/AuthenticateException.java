package com.fh.exception;


import utils.ServerEnum;

public class AuthenticateException extends RuntimeException{
    private Integer code;
    public AuthenticateException(ServerEnum serverEnum) {
        super(serverEnum.getMessage());
        this.code=serverEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }

}
