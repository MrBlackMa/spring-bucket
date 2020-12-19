package com.malixi.spring.service2.controller;

import com.malixi.spring.apijarone.api.OtherApi;
import org.springframework.web.bind.annotation.RestController;


/**
 * 类名不一样  请求方法的连接一样  都是service下的 alive
 *
 */
@RestController
public class TestFeignServiceController3 implements OtherApi {


    @Override
    public String getOther() {
        return "otherApi2";
    }
}