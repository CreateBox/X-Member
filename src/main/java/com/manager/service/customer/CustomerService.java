package com.manager.service.customer;

import com.manager.pojo.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCus(Customer customer, Integer ser, int start, int length);

    Integer getCusCount(Customer customer, Integer ser);

    Integer delCus(Integer id);

    Customer getCusById(Integer id);

    Integer updateCus(Customer customer);

    Integer addCus(Customer customer);

    Integer getcountSer(Integer s_id);


}
