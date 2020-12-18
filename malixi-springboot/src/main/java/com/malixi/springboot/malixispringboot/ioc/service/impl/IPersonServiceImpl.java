package com.malixi.springboot.malixispringboot.ioc.service.impl;

import com.malixi.springboot.malixispringboot.ioc.dao.IPersonDao;
import com.malixi.springboot.malixispringboot.ioc.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/12 - 17:04
 * @Description: com.malixi.springboot.malixispringboot.ioc.service.impl
 * @version: 1.0
 */
@Service
public class IPersonServiceImpl implements IPersonService {

    @Resource(name = "personDaoImpl")
    private IPersonDao iPersonDao;


    @Override
    public String list() {
        return iPersonDao.list();
    }
}
