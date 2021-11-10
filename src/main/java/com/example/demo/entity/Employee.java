package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="employee")
@Data //lombok
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "name")
    private String employee_name;

    @Column(name = "department_id")
    private int department_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable=false)
    private Department department;
}
