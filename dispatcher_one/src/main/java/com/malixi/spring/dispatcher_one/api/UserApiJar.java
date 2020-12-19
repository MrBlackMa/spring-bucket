package com.malixi.spring.dispatcher_one.api;


import com.malixi.spring.apijarone.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 17:19
 * @Description: com.malixi.spring.dispatcher_one.api
 * @version: 1.0
 */
@FeignClient(name="service",contextId = "user")
public interface UserApiJar extends UserApi {
}
