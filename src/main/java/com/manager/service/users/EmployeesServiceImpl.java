package com.manager.service.users;

import com.manager.mapper.EmployeesMapper;
import com.manager.pojo.Employees;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Resource
    private EmployeesMapper employeesMapper;

    @Override
    public Employees getEmployees(Employees employees) {
        Employees newEmployees = employeesMapper.getEmployees(employees);
        return newEmployees;
    }

    @Override
    @Transactional
    public int alterEmployees(Employees employees) {
        return employeesMapper.alterEmployees(employees);
    }

    @Override
    public List<Employees> employeeList(Integer begin,Integer end,Employees employees) {
        Map<String,Object> map = new HashMap<>();
        map.put("begin",begin);
        map.put("end",end);
        map.put("employee",employees);
        return employeesMapper.employeeList(map);
    }

    @Override
    public int count(Employees employees) {
        return employeesMapper.count(employees);
    }
}
