package com.forever.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2018/9/29.
 */
@RestController
public class MemberController {

    @RequestMapping(value = "i/e/{data}",method = RequestMethod.GET)
    public String execute(@PathVariable String data){
        System.out.println(data);
        return data;
    }
}
