package com.example.demo.model;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
    private int employee_id;
    private String name;
    private int department_id;
}
