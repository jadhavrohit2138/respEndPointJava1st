package com.SecondProj.SecondProj.services;

import com.SecondProj.SecondProj.entity.Employee;
import com.SecondProj.SecondProj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

     public List<Employee> getEmpData(){
       List<Employee> emp = employeeRepository.findAll();
       return emp;
     }
}
