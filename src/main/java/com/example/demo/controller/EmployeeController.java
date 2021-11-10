package com.example.demo.controller;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.EmployeeResponseDTO;
import com.example.demo.service.EmployeeServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeServiceInterface es;

    @Autowired
    public EmployeeController(EmployeeServiceInterface es){
        this.es = es;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> allEmployee = es.getAllEmployee();
        if(allEmployee==null || allEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Not found employees");
        }
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return new ResponseEntity<>(es.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Employee> updateEmploymentName(@PathVariable int id, @PathVariable String name){
        Employee empl= es.getEmployeeById(id);
        empl.setEmployee_name(name);
        return new ResponseEntity<>(es.updateEmployeeById(empl), HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee e){
        return new ResponseEntity<>(es.addEmployee(e), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable int id){
        return new ResponseEntity<>(es.deleteById(id),HttpStatus.NO_CONTENT);
    }


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeNotFoundException> errorResponse( Exception e){
        return new ResponseEntity<EmployeeNotFoundException>(HttpStatus.NOT_FOUND);
    }

}
