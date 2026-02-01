package com.apurba.spingboot.cruddemo.rest;

import com.apurba.spingboot.cruddemo.dao.EmployeeDAO;
import com.apurba.spingboot.cruddemo.entity.Employee;
import com.apurba.spingboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //expose "/employees/{employeeId}" and return a single employee
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null)
            throw new RuntimeException("Employee id not found " + employeeId);
        return theEmployee;
    }

    //expose "/employees" to add a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employeeDetails) {
        Employee newEmployee = employeeService.save(employeeDetails);
        return newEmployee;
    }
}
