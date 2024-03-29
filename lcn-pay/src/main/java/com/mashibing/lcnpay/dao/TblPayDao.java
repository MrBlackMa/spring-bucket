package com.mashibing.lcnpay.dao;

import com.mashibing.lcnpay.entity.TblPay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TblPayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblPay record);

    int insertSelective(TblPay record);

    TblPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblPay record);

    int updateByPrimaryKey(TblPay record);
}