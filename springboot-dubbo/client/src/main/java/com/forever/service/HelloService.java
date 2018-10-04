//package com.forever.service;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.forever.api.HelloServiceApi;
//import com.forever.domain.User;
//import org.springframework.stereotype.Service;
//
///**
// * Created by asus on 2018/9/28.
// */
//@Service
//public class HelloService {
//
//    @Reference(version = "1.0.0")
//    private HelloServiceApi helloServiceApi;
//
//    public void hello(){
//        helloServiceApi.hello();
//    }
//
//    public void insert(User user){
//        helloServiceApi.insertUser(user);
//    }
//
//    public User selectOne(Integer id){
//        return helloServiceApi.selectOne(id);
//    }
//}
