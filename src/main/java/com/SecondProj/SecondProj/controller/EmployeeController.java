package com.SecondProj.SecondProj.controller;


import com.SecondProj.SecondProj.entity.Employee;
import com.SecondProj.SecondProj.models.EmployeeRequest;
import com.SecondProj.SecondProj.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200/")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;
    // git_hub_repo_name : respEndPointJava1st

    @GetMapping("/users/export")
    public void exportToCSV(HttpServletResponse response) throws IOException, SQLException {
        employeeServices.exportToCSV(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllData() {
        ResponseEntity<List<Employee>> res;
        try {
            List<Employee> obj1 = employeeServices.getEmpData();
            res = ResponseEntity.status(HttpStatus.OK).body(obj1);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Employee>> getData(@PathVariable String name) {
        ResponseEntity<List<Employee>> res;
        try {
            if(name.equalsIgnoreCase("all"))
            {
                List<Employee> obj1 = employeeServices.getEmpData();
                res = ResponseEntity.status(HttpStatus.OK).body(obj1);
                return res;
            }
            else {
                List<Employee> obj1 = employeeServices.getByName(name);
                if (obj1.size()==0){
//                    List<Employee> obj2 = employeeServices.findByPlaceContaining(name);
//                    System.out.println(obj2);
                    List<Employee> empNullResp = Collections.singletonList(new Employee(0, name+" is not present at table", "null"));
                    res = ResponseEntity.status(HttpStatus.OK).body(empNullResp);
                }
                else {
                    res = ResponseEntity.status(HttpStatus.OK).body(obj1);
                }
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/add")
public Boolean saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
    ResponseEntity<String> response;
    return employeeServices.saveEmployee(employeeRequest);
}
    @DeleteMapping("/delete/{emp_id}")
    public Boolean deleteEmployee(@PathVariable int emp_id){
            return employeeServices.deleteEmp(emp_id);
    }
    @PutMapping("/update/{emp_id}")
    public Boolean updateEmployee(@PathVariable Integer emp_id,@RequestBody EmployeeRequest employeeRequest){
        return employeeServices.updateEmp(emp_id,employeeRequest);
    }
    @GetMapping("/id/{emp_id}")
    public Optional<Employee> getById(@PathVariable int emp_id){
        return  employeeServices.getById(emp_id);
    }
}


//    public Boolean saveEmployees(@RequestBody EmployeeRequest employee){
//        employeeServices.saveEmployee(employee);
//        return true;
//    }
//}
