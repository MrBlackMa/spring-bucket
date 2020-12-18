package com.malixi.springboot.malixispringboot.ioc.dao.impl;

import com.malixi.springboot.malixispringboot.ioc.dao.IPersonDao;
import org.springframework.stereotype.Repository;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/12 - 17:03
 * @Description: com.malixi.springboot.malixispringboot.ioc.dao.impl
 * @version: 1.0
 */
@Repository
public class PersonDaoImpl implements IPersonDao {
    @Override
    public String list() {
        return "i m list1";
    }
}
