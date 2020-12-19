package com.malixi.springboot.malixispringboot.controller;


import com.malixi.spring.apijarone.api.UserApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 15:56
 * @Description: com.malixi.springboot.malixispringboot.controller
 * @version: 1.0
 */
@RestController
public class TestFeignServiceController implements UserApi {



    @Override
    public String getUserInfo() {
        return "getUserInfo1";
    }
}
