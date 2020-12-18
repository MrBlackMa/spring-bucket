package com.malixi.spring.dispatcher_one.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/18 - 19:24
 * @Description: com.malixi.spring.dispatcher_one.controller
 * @version: 1.0
 */
@RestController
public class TestRibbonController {



    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    /**
     * ribbon的负载均衡测试
     * @return
     */
    @GetMapping("/client6")
    public Object client6() {

        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("service");


        String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/sayHi";
        System.out.println("url:"+url);


        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println("respStr:"  + respStr);

        return respStr;
    }


    /**
     * 自定义负载均衡
     * @return
     */

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/client7")
    public Object client7() {
        List<ServiceInstance> instances = discoveryClient.getInstances("service");

        // 自定义轮训算法
        // 随机
        int nextInt = new Random().nextInt(instances.size());
        AtomicInteger atomicInteger = new AtomicInteger();

        // 轮训
        int i = atomicInteger.getAndIncrement();
        instances.get(i % instances.size());
        // 权重。。
        for (ServiceInstance serviceInstance : instances) {
            //	int quanzhong = 	serviceInstance.getMetadata(); // 权重  1-9
        }
        ServiceInstance instance = instances.get(nextInt);
        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        //	ServiceInstance instance = lb.choose("provider");
        String url ="http://" + instance.getHost() +":"+ instance.getPort() + "/getHi";
        String respStr = restTemplate.getForObject(url, String.class);

        return respStr;
    }


    /**
     * ribbon的自动选择负载均衡 不需要   ServiceInstance instance = lb.choose("service");
     * @return
     */
    @GetMapping("/client8")
    public Object client8() {
        String url ="http://service/sayHi";
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:"  + respStr);
        return respStr;
    }

}
