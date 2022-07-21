package com.SecondProj.SecondProj.controller;


import com.SecondProj.SecondProj.entity.Employee;
import com.SecondProj.SecondProj.models.EmployeeRequest;
import com.SecondProj.SecondProj.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
public Boolean saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
    ResponseEntity<String> response;
    return employeeServices.saveEmployee(employeeRequest);
}
    @DeleteMapping("/delete/{emp_id}")
    public String deleteEmployee(@PathVariable int emp_id){
        Boolean flag =  employeeServices.deleteEmp(emp_id);
        if (flag) {
            return emp_id+" is deleted";
        }
        else {
            return "given id "+emp_id+" is not present";
        }
    }
    @PutMapping("/update/{emp_id}")
    public Boolean updateEmployee(@PathVariable Integer emp_id,@RequestBody EmployeeRequest employeeRequest){
        Boolean flag =  employeeServices.updateEmp(emp_id,employeeRequest);
        return flag;
    }
}


//    public Boolean saveEmployees(@RequestBody EmployeeRequest employee){
//        employeeServices.saveEmployee(employee);
//        return true;
//    }
//}
