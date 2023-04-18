package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

    //add first method called findAll() which is a list
    List<Employee> findAll();
}
