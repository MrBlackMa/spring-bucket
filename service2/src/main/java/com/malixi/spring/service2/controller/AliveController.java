package com.malixi.spring.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 18:56
 * @Description: com.malixi.spring.service2.controller
 * @version: 1.0
 */
@RestController
public class AliveController {

    @GetMapping("/alive")
    public String alive(){
        return "isok2";
    }
}
