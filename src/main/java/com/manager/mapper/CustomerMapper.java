package com.manager.mapper;

import com.manager.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    List<Customer> getCus(Map<String, Object> map);

    Integer getCusCount(Map<String, Object> map);

    Integer delCus(@Param("id") Integer id);

    Customer getCusById(@Param("id") Integer id);

    Integer updateCus(@Param("cus") Customer customer);

    Integer addCus(@Param("cus") Customer customer);

    Integer getcountSer(@Param("s_id") Integer s_id);
}
