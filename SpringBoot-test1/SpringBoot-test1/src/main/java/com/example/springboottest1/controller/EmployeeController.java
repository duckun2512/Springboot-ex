package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Employee;
import com.example.springboottest1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    private static ArrayList<Employee> listEmployee;
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Employee> getList() {
        return listEmployee;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Employee getDetail(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{name}")
    public Employee findByName(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, path = "{id}")
    public Employee create(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee updateEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employee.setName(updateEmployee.getName());
            employee.setSalary(updateEmployee.getSalary());
            employeeRepository.save(employee);
        }
        return employee;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean delete(@PathVariable int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employeeRepository.delete(employee);
            return true;
        }
        return false;
    }
}
