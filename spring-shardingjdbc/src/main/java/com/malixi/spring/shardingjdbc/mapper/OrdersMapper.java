package com.malixi.spring.shardingjdbc.mapper;

import com.malixi.spring.shardingjdbc.bean.Address;
import com.malixi.spring.shardingjdbc.bean.DictOrderType;
import com.malixi.spring.shardingjdbc.bean.Orders;
import com.malixi.spring.shardingjdbc.bean.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Auther: smile malixi
 * @Date: 2020/12/9 - 16:12
 * @Description: com.malixi.spring.shardingjdbc.mapper
 * @version: 1.0
 */
@Repository
@Mapper
public interface OrdersMapper {

    @Insert("insert into t_orders values(#{id},#{orderType},#{customerId},#{amount})")
    public void insertOrders(Orders orders);

    @Insert("insert into t_orders values(#{id},#{orderType},#{customerId},#{amount})")
    public void insertOrders2(Orders orders);

    @Insert("insert into dict_order_type values(#{id},#{orderType})")
    public void insertDictType(DictOrderType dictOrderType);

    @Insert("insert into dict_order_type values(#{id},#{orderType})")
    public void insertDictType2(DictOrderType dictOrderType);

    @Insert("insert into t_person values(#{id},#{name})")
    public void insertPerson(Person person);

    @Insert("insert into t_address values(#{id},#{address})")
    public void insertAddress(Address address);

    @Select("select * from t_orders where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "orderType",column = "order_type"),
            @Result(property = "customerId",column = "customer_id"),
            @Result(property = "amount",column = "amount")
    })
    public Orders selectOrdersById(Integer id);


    @Select("select * from t_person where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    public Person selectPersonById(Integer id);
}
