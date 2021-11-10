package com.example.demo.service.Impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getById(id);
    }


    @Override
    public Employee updateEmployeeById(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee addEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Boolean deleteById(int id) {
        return employeeRepository.deleteById(id);
    }


}
