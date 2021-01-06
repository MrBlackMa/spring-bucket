package com.malixi.spring.myzuul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/23 - 21:17
 * @Description: csrf 攻擊類
 * @version: 1.0
 */
@Controller
public class CsrfControoler {


    @RequestMapping("/demo")
    public String demo(){
        return "demo";
    }
}
