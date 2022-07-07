package com.SecondProj.SecondProj.controller;

import com.SecondProj.SecondProj.entity.Employee;
import com.SecondProj.SecondProj.models.EmployeeRequest;
import com.SecondProj.SecondProj.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
//    @PostMapping("/add")
//    public Boolean saveEmployees(@RequestBody EmployeeRequest employee){
//        employeeServices.saveEmployee(employee);
//        return true;
//    }
}
