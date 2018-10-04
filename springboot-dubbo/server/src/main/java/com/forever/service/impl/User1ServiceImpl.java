package com.forever.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.forever.api.User1Service;
import com.forever.dao.two.User1Mapper;
import com.forever.domain.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/10/4.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Component
@Service(version = "1.0.0",interfaceName = "com.forever.api.User1Service")
public class User1ServiceImpl implements User1Service {
    @Autowired
    private User1Mapper user1Mapper;
    @Override
    public void save(User1 user1) {
        user1Mapper.insert(user1);
    }
}
