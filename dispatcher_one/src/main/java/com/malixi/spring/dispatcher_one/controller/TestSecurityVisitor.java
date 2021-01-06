package com.malixi.spring.dispatcher_one.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/24 - 2:20
 * @Description: 针对security所有的放行请求过来测试
 *               注意 安全请求分两种 一种是 是否登录的请求 ,登录的请求走另外的security 业务的权限认证,
 *               没登录的请求开启csrf防御 验证 这种验证就是令牌的模式 每次请求跟着token 分布式的情况下可以关闭
 *               csrf（未验证）  因为分布式的jwt（json web token） 每次请求都验证token的权限及会话保持
 *               没登录的请求走 session&token验证
 *
 * @version: 1.0
 */
@RestController
public class TestSecurityVisitor {

    @RequestMapping("/visitor/getVisitor")
    public String visitor(){
      return "我是游客模式的请求";
    }
}
