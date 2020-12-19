package com.malixi.spring.service2.controller;

import com.malixi.spring.apijarone.api.OtherApi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


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

    @Override
    public String getOtherById(@RequestParam String id) {
        System.out.println(id);
        return id;
    }

    @Override
    public Map<String,Object> getOtherByMap(@RequestParam Map<String, Object> map) {
        System.out.println("1:"+map);
        return map;
    }

    @Override
    public Map<String, Object> getOtherByPost(@RequestBody  Map<String, Object> map) {
        System.out.println("post1:"+map);
        return map;
    }
}