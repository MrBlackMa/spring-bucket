package com.malixi.spring.dispatcher_one.controller;

import com.malixi.spring.dispatcher_one.service.TemplateHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/20 - 20:41
 * @Description: com.malixi.spring.dispatcher_one.controller
 * @version: 1.0
 */
@RestController
public class TestRestTemplateHysTrixController {
    @Autowired
    TemplateHystrix templateHystrix;

    @RequestMapping("/getOrderInfo2")
    public String getOrderInfo2(){
        return templateHystrix.getOrderInfo2();
    }
}
