package com.forever.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.forever.api.UserService;
import com.forever.dao.one.UserMapper;
import com.forever.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/10/3.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Component
@Service(version = "1.0.0",interfaceName = "com.forever.api.UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User get(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }
}
