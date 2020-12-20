package com.malixi.spring.dispatcher_one.api;


import com.malixi.spring.apijarone.api.OrderApi;

import com.malixi.spring.dispatcher_one.main.hsytirx.exception.OrderBackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 19:12
 * @Description: com.malixi.spring.dispatcher_one.api
 * @version: 1.0
 */
@FeignClient(name="service",contextId = "order",fallbackFactory = OrderBackFactory.class)
public interface OrderApiJar extends OrderApi {

}
