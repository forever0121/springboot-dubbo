package com.forever.api;

import com.forever.domain.User;

import java.util.List;

/**
 * Created by asus on 2018/9/28.
 */
public interface HelloServiceApi {

    void hello();

    void insertUser(User user);

    User selectOne(Integer id);

    void test();
}
