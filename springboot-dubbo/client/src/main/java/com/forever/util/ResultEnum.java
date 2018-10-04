package com.forever.util;

/**
 * Created by asus on 2018/10/2.
 */
public enum ResultEnum {
    LOGIN_ERROR("登录出错");

    private String msg;
    private String code;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    ResultEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
