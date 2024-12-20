package net.demo.projectjpa.employeesprintbootproject.entity;

import jakarta.persistence.*;
import lombok.Data;


    @Data
    @Entity
    @Table(name = "employee")
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private int age;
        private int salary;
        private String email;

    }
