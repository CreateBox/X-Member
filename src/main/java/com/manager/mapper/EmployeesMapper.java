package com.manager.mapper;

import com.manager.pojo.Employees;

import java.util.List;
import java.util.Map;

public interface EmployeesMapper {
    Employees getEmployees(Employees employees);

    int alterEmployees(Employees employees);

    List<Employees> employeeList(Map map);

    int count(Employees employees);

    List<Employees> lowerList(Employees employees);
}
