package com.mashibing.lcnorder.dao;

import com.mashibing.lcnorder.entity.TblOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TblOrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblOrder record);

    int insertSelective(TblOrder record);

    TblOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblOrder record);

    int updateByPrimaryKey(TblOrder record);
}