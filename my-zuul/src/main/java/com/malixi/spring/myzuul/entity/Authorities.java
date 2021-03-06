package com.malixi.spring.myzuul.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/25 - 20:40
 * @Description: com.malixi.spring.myzuul.entity
 * @version: 1.0
 */
public class Authorities implements GrantedAuthority {

    private String userName;

    private String authority;

    private String UUID= "112233";

    public String getUUID() {
        return UUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
