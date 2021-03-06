package com.malixi.springboot.malixispringboot.controller;


import com.malixi.spring.apijarone.api.OrderApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 19:16
 * @Description: com.malixi.spring.service2.controller
 * @version: 1.0
 */
@RestController
public class OrderController implements OrderApi {
    @Value("${server.port}")
    String port;
    @Override
    public String getOrderInfo() {
        int i=1/0;
        return "getOrderInfo2";
    }


    @RequestMapping("/getOrderInfo2")
    public String getOrderInfo2() {
        int i=1/0;
        return port+":getOrderInfo2";
    }

    /**
     * 测试zuul的负载均衡
     * @return
     */
    @RequestMapping("/order/getZuulTest")
    public String getZuulTest() {
        return port+":getZuulTest";
    }
}
