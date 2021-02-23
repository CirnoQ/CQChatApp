package com.cirnoq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/userlist")
    public String userList(){
        return "user_list";
    }


}
