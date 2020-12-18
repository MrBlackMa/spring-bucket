package com.malixi.springboot.malixispringboot.ioc.dao.impl;

import com.malixi.springboot.malixispringboot.ioc.dao.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/12 - 17:08
 * @Description: com.malixi.springboot.malixispringboot.ioc.dao.impl
 * @version: 1.0
 */
@Repository
public class PersonDaoImpl2 implements IPersonDao {
    @Override
    public String list() {
        return "i m list2";
    }
}
