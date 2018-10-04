package com.forever.api;

import com.forever.domain.User;

/**
 * Created by asus on 2018/10/3.
 */
public interface UserService {
    User get(String name);

    void save(User user);
}
