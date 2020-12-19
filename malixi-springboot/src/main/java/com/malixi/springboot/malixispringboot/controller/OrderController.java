package com.malixi.springboot.malixispringboot.controller;


import com.malixi.spring.apijarone.api.OrderApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 19:16
 * @Description: com.malixi.spring.service2.controller
 * @version: 1.0
 */
@RestController
public class OrderController implements OrderApi {
    @Override
    public String getOrderInfo() {
        return "getOrderInfo2";
    }
}
