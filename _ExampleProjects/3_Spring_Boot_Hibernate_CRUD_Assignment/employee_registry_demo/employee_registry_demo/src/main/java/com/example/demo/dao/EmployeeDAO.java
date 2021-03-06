package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //DAO Methods
    List<Employee> findAll();
    Employee findById(int theId);
    void save(Employee theEmployee);
    void deleteById(int theId);
}
