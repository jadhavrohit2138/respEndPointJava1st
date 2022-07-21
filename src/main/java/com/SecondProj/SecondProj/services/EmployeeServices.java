package com.SecondProj.SecondProj.services;

import com.SecondProj.SecondProj.entity.Employee;
import com.SecondProj.SecondProj.models.EmployeeRequest;
import com.SecondProj.SecondProj.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServices {
    Logger logger = LogManager.getLogger(EmployeeServices.class);
    @Autowired
    private EmployeeRepository employeeRepository;
     public List<Employee> getEmpData(){
         logger.info("INFORMATION ! ! ! ! !");
         logger.warn("WARNING ! ! ! !");
         logger.debug("Debug ! ! ! ! !");
         logger.error("ERROR ! ! ! ! !");
         return employeeRepository.findAll();
     }

     public Boolean saveEmployee(EmployeeRequest employee){
    try {
        if (Objects.nonNull(employee.getEmpId())) {
        Optional<Employee> empData = employeeRepository.findById(employee.getEmpId());
        Employee getData = empData.get();
        getData.setEmpId(employee.getEmpId());
        getData.setLoc(employee.getLoc());
        getData.setName(employee.getName());
        Employee updateData = employeeRepository.save(getData);
//        System.out.println("getDada");
        return true;
        }
        else {
        Employee empL = new Employee();
        empL.setName(employee.getName());
        empL.setLoc(employee.getLoc());
        Employee savedEmployee = employeeRepository.save(empL);
        return true;
        }
    } catch (Exception e) {
        logger.error("Error Message Logged !!!", new Exception("Error"));
    return  false;
    }
     }

    public Boolean deleteEmp(int emp_id) {
         try {
             Employee emp = employeeRepository.getReferenceById(emp_id);
             Optional<Employee> empId = employeeRepository.findById(emp_id);
             if(empId.isPresent()){
                 employeeRepository.delete(emp);
                 return true;
             }
            else {
                return false;
             }
         }
         catch (Exception e){
             logger.error("Error Message Logged !!!", new Exception("Error"));
             return false;
         }
    }

    public Boolean updateEmp(Integer emp_id, EmployeeRequest employeeRequest) {
        Optional<Employee> empData = employeeRepository.findById(emp_id);
        if (empData.isPresent()) {
            Employee getData = empData.get();
            getData.setLoc(employeeRequest.getLoc());
            getData.setName(employeeRequest.getName());
            Employee updateData = employeeRepository.save(getData);
            return true;
        }else {
            return false;
        }
    }
}

