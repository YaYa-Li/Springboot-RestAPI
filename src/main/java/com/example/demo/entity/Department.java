package com.example.demo.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private int department_id;

    @Column(name = "department_name")
    private String department_name;

    @OneToMany(mappedBy = "department_id", cascade = CascadeType.ALL)
    private Set<Employee> employee = new HashSet<>();
}
