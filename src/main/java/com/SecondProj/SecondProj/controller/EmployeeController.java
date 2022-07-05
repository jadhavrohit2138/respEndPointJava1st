package com.SecondProj.SecondProj.controller;

import com.SecondProj.SecondProj.entity.Employee;
import com.SecondProj.SecondProj.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getData() {
        ResponseEntity<List<Employee>> res;
        try {
            List<Employee> obj1 = employeeServices.getEmpData();
            res = ResponseEntity.status(HttpStatus.OK).body(obj1);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
