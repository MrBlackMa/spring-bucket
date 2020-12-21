package com.malixi.spring.dispatcher_one.controller;

import com.malixi.spring.dispatcher_one.api.OrderApiJar;
import com.malixi.spring.dispatcher_one.service.TemplateHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/20 - 20:41
 * @Description:测试zuul负载均衡的类
 * @version: 1.0
 */
@RestController
public class TestZuulController {

    @Autowired
    OrderApiJar orderApiJar;

    @Value("${server.port}")
    String port;


    /**
     * 测试Zuul网关的负载均衡
     * @return
     */
    @RequestMapping("/getZuulTest")
    public String getZuulTest(){
        return port+"----->"+orderApiJar.getZuulTest();
    }

}
