package com.sixplus.demo.Constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HttpResponseStatusEnum implements CommonResponse{
    SUCCESS("0","success"),FORBIDDEN_OPERATION("2","forbidden");

    private String code;
    private String message;

    @Override
    public String getCode(){return code;}

    @Override
    public String getMessage(){return message;}

    @Override
    public Object getResult(){return null;}

}
