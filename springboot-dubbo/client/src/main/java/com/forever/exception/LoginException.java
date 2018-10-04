package com.forever.exception;

import com.forever.util.ResultEnum;

/**
 * Created by asus on 2018/10/2.
 */
public class LoginException extends RuntimeException {

    public LoginException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
