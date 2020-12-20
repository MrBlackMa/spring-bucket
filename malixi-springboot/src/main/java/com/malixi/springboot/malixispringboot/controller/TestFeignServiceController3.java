package com.malixi.springboot.malixispringboot.controller;


import com.malixi.spring.apijarone.api.OtherApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestFeignServiceController3 implements OtherApi {


    @Override
    public String getOther() {
        return "otherApi1";
    }

    @GetMapping("/other/getAlive")
    public String getAlive() {
        return "getAlive";
    }

    @Override
    public String getOtherById(@RequestParam String id) {
        System.out.println(id);
        return id;
    }

    @Override
    public Map<String,Object> getOtherByMap(@RequestParam Map<String, Object> map) {
        System.out.println("2:"+map);
        return map;
    }

    @Override
    public Map<String, Object> getOtherByPost(@RequestBody Map<String, Object> map) {
        System.out.println("post2:"+map);
        return map;
    }
}