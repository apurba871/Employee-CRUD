package com.apurba.spingboot.cruddemo.service;

import com.apurba.spingboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
