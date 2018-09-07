package com.manager.service.customer;

import com.manager.mapper.CustomerMapper;
import com.manager.pojo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getCus(Customer customer, Integer ser, int start, int length) {
        Map<String, Object> map = new HashMap<>();
        map.put("cus", customer);
        map.put("ser", ser);
        map.put("start", start);
        map.put("length", length);
        return customerMapper.getCus(map);
    }

    @Override
    public Integer getcountSer(Integer s_id) {
        return customerMapper.getcountSer(s_id);
    }

    @Override
    public Integer getCusCount(Customer customer, Integer ser) {
        Map<String, Object> map = new HashMap<>();
        map.put("cus", customer);
        map.put("ser", ser);
        return customerMapper.getCusCount(map);
    }

    @Override
    public Integer delCus(Integer id) {
        return customerMapper.delCus(id);
    }

    @Override
    public Customer getCusById(Integer id) {
        return customerMapper.getCusById(id);
    }

    @Override
    public Integer updateCus(Customer customer) {
        return customerMapper.updateCus(customer);
    }

    @Override
    public Integer addCus(Customer customer) {
        return customerMapper.addCus(customer);
    }
}
