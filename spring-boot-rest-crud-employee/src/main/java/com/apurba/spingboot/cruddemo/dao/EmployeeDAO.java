package com.apurba.spingboot.cruddemo.dao;

import com.apurba.spingboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
