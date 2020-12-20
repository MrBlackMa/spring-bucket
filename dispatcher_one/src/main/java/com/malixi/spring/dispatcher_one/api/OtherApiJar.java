package com.malixi.spring.dispatcher_one.api;


import com.malixi.spring.apijarone.api.OtherApi;

import com.malixi.spring.dispatcher_one.main.hsytirx.exception.AliveBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 18:32
 * @Description: com.malixi.spring.dispatcher_one.api
 * @version: 1.0
 */
@FeignClient(name="service",contextId = "other",fallback = AliveBack.class)
public interface OtherApiJar extends OtherApi {

    /**
     * 自己客户端写接口
     * @return
     */
    @RequestMapping("/other/getAlive")
    public String getAlive();
}
