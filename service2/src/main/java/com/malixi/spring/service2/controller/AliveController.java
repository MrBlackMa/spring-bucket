package com.malixi.spring.service2.controller;

import com.malixi.spring.service2.model.Model;
import com.malixi.spring.service2.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MyService myService;

    @GetMapping("/alive")
    public String alive(){
        return "isok2";
    }


    @GetMapping("/getAlive")
    public Model getAlive(){
         return myService.findById(1L);
    }
}
