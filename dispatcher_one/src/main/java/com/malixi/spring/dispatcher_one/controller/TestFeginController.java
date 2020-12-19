package com.malixi.spring.dispatcher_one.controller;


import com.malixi.spring.dispatcher_one.api.OrderApiJar;
import com.malixi.spring.dispatcher_one.api.OtherApiJar;
import com.malixi.spring.dispatcher_one.api.UserApiJar;
import com.malixi.spring.dispatcher_one.api.UserRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/19 - 15:46
 * @Description: 测试fegin的类
 * @version: 1.0
 */
@RestController
public class TestFeginController {



    @Autowired
    UserApiJar userApiJar;

    @Autowired
    OtherApiJar otherApiJar;

    @Autowired
    UserRestApi userRestApi;

    @Autowired
    OrderApiJar orderApiJar;

    /**
     * 该方法验证不用导包的形式直接走rest 的fegin
     * @return
     */
    @GetMapping("/alive")
    public String alive() {
        return userRestApi.alive();
    }

    /**
     * 该方法验证多个fegin的情况下 分接口类怎么处理
     * @return
     */
    @RequestMapping("/getOther")
    public String getOther(){
        return otherApiJar.getOther();
    }

    /**
     * 该方法验证提供jar的形式直接调用api
     * 走fegin
     * @return
     */
    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        return userApiJar.getUserInfo();
    }


    /**
     * 该方法验证 api-jar-one直接更新 同一个项目组下
     * 不用install  然后调度包直接用是否可行
     * @return
     */
    @GetMapping("/getOrderInfo")
    public String getOrderInfo() {
        return orderApiJar.getOrderInfo();
    }
}
