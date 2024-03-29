package com.malixi.spring.dispatcher_one.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/20 - 20:35
 * @Description: restTemplate的熔断异常处理类
 * @version: 1.0
 */
@Service
public class TemplateHystrix {
    @Autowired
    RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "back")
        public String getOrderInfo2() {
        //ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("service+bbb");
        String url ="http://service/order/getOrderInfo";
        String object = restTemplate.getForObject(url, String.class);

        return object;

    }


    public String back() {

        return "请求失败~bbb...";
    }
}
