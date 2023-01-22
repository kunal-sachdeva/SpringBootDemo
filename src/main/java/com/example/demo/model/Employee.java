package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "SALARY")
    private BigInteger salary;
    @Column(name = "JOINING_DATE")
    private Timestamp joiningDate;
    @Column(name = "DESIGNATION")
    private String designation;
}
