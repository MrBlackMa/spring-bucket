package com.malixi.spring.myzuul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/24 - 1:47
 * @Description: com.malixi.spring.myzuul.controller
 * @version: 1.0
 */
@Controller
public class MainController {

    @RequestMapping("/login")
    public String getCsrf(){

        return "login";
    }


    @RequestMapping("/UserNpError")
    public String UserNpError(){
        System.out.println("进入了该方法");
        return "UserNpError";
    }
}