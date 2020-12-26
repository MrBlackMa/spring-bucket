package com.malixi.spring.myzuul;

import com.malixi.spring.myzuul.entity.Authorities;
import com.malixi.spring.myzuul.entity.Authorities2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/26 - 14:22
 * @Description: com.malixi.spring.myzuul
 * @version: 1.0
 */
public class TestMain {

    public static void main(String[] args) {
        List<Authorities2> listset=new ArrayList<>();
        List<Map<String,Object>> list=new ArrayList<>();
        Map map=new HashMap();
        map.put("authority","role_admin");
        list.add(map);

        Map map2=new HashMap();
        map2.put("authority","role_ooxx");
        list.add(map2);


        for(int i=0;i<list.size();i++){
            Authorities2 authorities2 =new Authorities2();
            authorities2.setAuthority(list.get(i).get("authority").toString());
            listset.add(authorities2);
        }

        System.out.println(listset);

    }
}
