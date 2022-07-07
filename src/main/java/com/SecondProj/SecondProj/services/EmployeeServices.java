package com.SecondProj.SecondProj.services;

import com.SecondProj.SecondProj.entity.Employee;
//import com.SecondProj.SecondProj.repository.EmpRepository;
import com.SecondProj.SecondProj.models.EmployeeRequest;
import com.SecondProj.SecondProj.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

     public List<Employee> getEmpData(){
       List<Employee> emp = employeeRepository.findAll();
       return emp;
     }

//     public Boolean saveEmployee(EmployeeRequest employee){
//
//         try
//         {
//             Optional<Employee> empData = employeeRepository.findById(employee.getEmpId());
//             System.out.println("data will be inserted");
//
//         }
//         catch (Exception e){
//             System.out.println("data will be updated");
//         }
////            Employee empObj = new Employee(12,"AB","CD");
////            employeeRepository.save(empObj);
//         return true;
//     }
}
