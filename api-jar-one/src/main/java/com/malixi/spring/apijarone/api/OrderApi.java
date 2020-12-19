package com.malixi.spring.apijarone.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 19:11
 * @Description: com.malixi.spring.jar.api
 * @version: 1.0
 */
@RequestMapping("/order")
public interface OrderApi {
    @GetMapping("/getOrderInfo")
    public String getOrderInfo();
}
