package com.malixi.spring.myzuul.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/23 - 21:17
 * @Description: csrf 攻擊類
 * @version: 1.0
 */
@RestController
public class CsrfControoler {


    @RequestMapping("/csrf")
    @PreAuthorize("hasRole('ROLE_admin')") //需包含user角色
     // @PreAuthorize("haAnyRole('ROLE_admin','ROLE_user')") 需包含user或admin角色
    // @PreAuthorize("hasRole('ROLE_admin') AND hasRole('ROLE_user')") 需包含user或admin角色
    public String getCsrf(){
        // 获取全局权限
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        authentication.getPrincipal()
        System.out.println("大爷,您来了~");
        return "csrf";
    }

    @RequestMapping("/user/csrf")
    public String getUserCsrf(){
        System.out.println("大爷,您来了~");
        return "usercsrf";
    }

    @RequestMapping("/admin/csrf")
    public String getAdminCsrf(){
        System.out.println("大爷,您来了~");
        return "admincsrf";
    }



}
