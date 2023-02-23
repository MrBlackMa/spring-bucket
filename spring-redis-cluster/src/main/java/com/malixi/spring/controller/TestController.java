package com.malixi.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> template;

    @RequestMapping("/test")
    public String test() {
        template.opsForValue().set("demo", "hello world! 你好，世界");
        String str = (String) template.opsForValue().get("demo");
        return str;
    }

}