package com.manager.mapper;

import com.manager.pojo.Employees;

public interface EmployeesMapper {
    Employees getEmployees(Employees employees);

    int alterEmployees(Employees employees);
}
