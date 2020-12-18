package com.malixi.spring.dispatcher_one.controller;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/18 - 19:24
 * @Description: com.malixi.spring.dispatcher_one.controller
 * @version: 1.0
 */
@RestController
public class TestRestTemplateController {



    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 没给spring容器注册 restTemplate 并且没加LoadBalanced
     * @return
     */
    @GetMapping("/client9")
    public Object client9() {
        String url ="http://service/sayHi";
        String respStr = restTemplate.getForObject(url, String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity);
        restTemplate.getForEntity(url, String.class);
        System.out.println("respStr:"  + respStr);
        return respStr;
    }

    /**
     * 返回map
     * @return
     */
    @GetMapping("/client10")
    public Object client10() {
        String url ="http://service/getMap";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);
        System.out.println(forEntity);
        return forEntity;
    }

    /**
     * 返回对象
     * @return
     */
    @GetMapping("/client11")
    public Object client11() {
        String url ="http://service/getPerson";
         ResponseEntity<Object> forEntity = restTemplate.getForEntity(url, Object.class);
        System.out.println(forEntity);
        return forEntity;
    }

    /**
     * 参数传递的方式调用 post方式
     */
    @GetMapping("/client12")
    public Object client12() {
        String url ="http://service/getMap2";
        Map<String,Object> map= Collections.singletonMap("name","malixi");
        System.out.println(map);
        Map<String,Object> map1 = restTemplate.postForObject(url, map, Map.class);
        System.out.println(map1);
        return map1;
    }

    /**
     * 重定向
     */
    @RequestMapping("/client13")
    public void  client13(HttpServletResponse response) throws IOException {
        String url ="http://service/postForLocation";

        Map<String, String> map = Collections.singletonMap("name", " memeda");
        URI location = restTemplate.postForLocation(url, map,Object.class);

        System.out.println(location);
        response.sendRedirect(location.toString());
      //springmvd的跳转方式  return "redirect:"+location;
    }

}
