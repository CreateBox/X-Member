package com.manager.service.users;

import com.manager.pojo.Employees;

import java.util.List;

public interface EmployeesService {
    Employees getEmployees(Employees employees);

    int alterEmployees(Employees employees);

    List<Employees> employeeList(Integer begin, Integer end, Employees employees);

    int count(Employees employees);

    List<Employees> lowerList(Employees employees);

}
