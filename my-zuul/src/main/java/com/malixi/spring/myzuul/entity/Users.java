package com.malixi.spring.myzuul.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/25 - 20:38
 * @Description: 继承security的userdetails.User 扩展自己的user
 * @version: 1.0
 */
public class Users extends User {
    private String userName;

    private String passWord;

    private int enabled;

    private Set<GrantedAuthority> set;

    public Users(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<GrantedAuthority> getSet() {
        return set;
    }

    public void setSet(Set<GrantedAuthority> set) {
        this.set = set;
    }

}
