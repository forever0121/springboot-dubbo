package com.forever.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.forever.api.HelloServiceApi;
import com.forever.api.UserService;
import com.forever.domain.User;
import com.forever.util.Audience;
import com.forever.util.JwtHelper;
import com.forever.util.ResultVOUtil;
import com.forever.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by asus on 2018/9/28.
 */
@RestController
public class HelloController {

    @Reference(version = "1.0.0",timeout = 10000)
    private HelloServiceApi helloServiceApi;
    @Reference(version = "1.0.0")
    private UserService userService;

    @Autowired
    private Audience audience;
    @RequestMapping(value = "hello/{name}",method = RequestMethod.GET)
    public String hello(@PathVariable String name){
//        helloServiceApi.hello();
//        User user = new User();
//        user.setName("11");
//        helloServiceApi.insertUser(user);
        User user = helloServiceApi.selectOne(2);
        return user.toString();
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public void test(){
        helloServiceApi.test();
    }

    @PostMapping("login")
    public ResultVo login(String name,HttpServletRequest request) {
        User query_user = userService.get(name);
        if (query_user == null) {
            return ResultVOUtil.error("400", "用户名错误");
        }
        String jwtToken = JwtHelper.createJWT(query_user.getName(),
                query_user.getId().toString(),
//                query_user.getRole().toString(),
                audience.getClientId(),
                audience.getName(),
                audience.getExpiresSecond()*1000,
                audience.getBase64Secret());
        String result_str = "bearer;" + jwtToken;
        return ResultVOUtil.success(result_str);
    }

}
