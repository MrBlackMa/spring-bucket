package com.malixi.spring.myzuul.service;

import com.malixi.spring.myzuul.entity.Authorities;
import com.malixi.spring.myzuul.entity.Users;
import com.malixi.spring.myzuul.mapper.MyUserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/25 - 20:07
 * @Description: 只提供查询信息 根据name  不能做校验
 * @version: 1.0
 */


public class MyDetailService implements UserDetailsService {

    @Autowired
    private MyUserServiceMapper myUserServiceMapper;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<Map<String,Object>> list = myUserServiceMapper.selectUsers(userName); //用户名唯一 且不可重复
        Map<String, Object> map = list.get(0);
        Set<Authorities> set=new HashSet<>();
        for(int i=0;i<list.size();i++){
            Authorities authorities =new Authorities();
            authorities.setAuthority(list.get(i).get("authority").toString());
            authorities.setUserName(list.get(i).get("username").toString());
            set.add(authorities);
        }
        Users users=new Users(map.get("username").toString(),map.get("PASSWORD").toString(),set);
        return users;
    }
}
