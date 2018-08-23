package com.manager.service.users;

import com.manager.mapper.EmployeesMapper;
import com.manager.pojo.Employees;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Resource
    private EmployeesMapper usersMapper;

    @Override
    public Employees getEmployees(Employees employees) {
        Employees newEmployees = usersMapper.getEmployees(employees);
        return newEmployees;
    }

    @Override
    @Transactional
    public int alterEmployees(Employees employees) {
        return usersMapper.alterEmployees(employees);
    }
}
