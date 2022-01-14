package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Employee;
import com.example.springboottest1.repository.EmployeeRepository;
import com.example.springboottest1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {

    private static ArrayList<Employee> listEmployee;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Employee> getList() {
        return listEmployee;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeService.findById(id);
        if (optionalEmployee.isPresent()) {
            return new ResponseEntity<>(employeeService.findById(id).orElse(null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "{id}")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
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
