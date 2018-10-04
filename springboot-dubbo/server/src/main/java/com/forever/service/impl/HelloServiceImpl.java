package com.forever.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.forever.api.HelloServiceApi;
import com.forever.api.User1Service;
import com.forever.api.UserService;
import com.forever.dao.one.UserMapper;
import com.forever.domain.User;
import com.forever.domain.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2018/9/28.
 */
@SuppressWarnings("ALL")
@Component
@Service(version = "1.0.0",interfaceName = "com.forever.api.HelloServiceApi")
//@CacheConfig(cacheNames = "user")
public class HelloServiceImpl implements HelloServiceApi {
    @Override
    public void hello() {
        System.out.println("已经调用提供者");
    }

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private User1Service user1Service;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(User user) {
        userMapper.insertSelective(user);
        int i = 1/0;
    }

    @Override
    public User selectOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(transactionManager = "xatx",
            propagation = Propagation.REQUIRED, rollbackFor = { java.lang.RuntimeException.class })
    public void test() {
        User u = new User();
        u.setName("u");
        userService.save(u);
        User1 u1 = new User1();
        u1.setName("u1");
        user1Service.save(u1);
        int i = 1/0;
        System.out.println("分布式事务同步成功");
    }


}
