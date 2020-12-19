package com.malixi.springboot.malixispringboot.controller;


import com.malixi.spring.apijarone.api.OtherApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFeignServiceController3 implements OtherApi {


    @Override
    public String getOther() {
        return "otherApi1";
    }
}