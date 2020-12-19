package com.malixi.spring.dispatcher_one.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 18:47
 * @Description: com.malixi.spring.dispatcher_one.api
 * @version: 1.0
 */
@FeignClient(name="service",contextId = "userRest")
public interface UserRestApi {

    @GetMapping("/alive")
    public String alive();
}
