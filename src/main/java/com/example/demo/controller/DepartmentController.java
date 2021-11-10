package com.example.demo.controller;


import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.service.DepartmentServiceInterface;
import com.example.demo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentServiceInterface ds;

    @Autowired
    public DepartmentController(DepartmentServiceInterface ds){
        this.ds = ds;
    }

    @GetMapping("")
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> allDepartment = ds.getAllDepartment();
//        if(allDepartment==null || allDepartment.size()==0){
//            return new ResponseEntity<DepartmentNotFoundException>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(allDepartment, HttpStatus.OK);
    }


    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<DepartmentNotFoundException> errorResponse( Exception e){
        return new ResponseEntity<DepartmentNotFoundException>(HttpStatus.NO_CONTENT);
    }
}
