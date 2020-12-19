package com.malixi.spring.dispatcher_one.api;


import com.malixi.spring.apijarone.api.OtherApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 18:32
 * @Description: com.malixi.spring.dispatcher_one.api
 * @version: 1.0
 */
@FeignClient(name="service",contextId = "other")
public interface OtherApiJar extends OtherApi {
}
