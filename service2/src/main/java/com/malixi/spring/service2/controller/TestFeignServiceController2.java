package com.malixi.spring.service2.controller;


import com.malixi.spring.apijarone.api.UserApi;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 *
 */
@RestController
public class TestFeignServiceController2 implements UserApi {


    @Override
    public String getUserInfo() {
        return "getUserInfo2";
    }
}