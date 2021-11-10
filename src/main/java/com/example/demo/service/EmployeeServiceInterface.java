package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    Employee updateEmployeeById(Employee e);

    Employee addEmployee(Employee e);

    Boolean deleteById(int id);
}
