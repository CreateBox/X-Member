package com.manager.service.users;

import com.manager.pojo.Employees;

public interface EmployeesService {
    Employees getEmployees(Employees employees);

    int alterEmployees(Employees employees);
}
