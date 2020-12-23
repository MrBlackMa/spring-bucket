package com.malixi.spring.myzuul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/23 - 21:17
 * @Description: csrf 攻擊類
 * @version: 1.0
 */
@RestController
public class CsrfControoler {


    @RequestMapping("/csrf")
    public String getCsrf(){
        return "csrf";
    }
}
