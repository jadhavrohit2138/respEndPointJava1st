package com.SecondProj.SecondProj.services;

import com.SecondProj.SecondProj.entity.Employee;
import com.SecondProj.SecondProj.models.EmployeeRequest;
import com.SecondProj.SecondProj.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
//@EnableScheduling
@Service
public class EmployeeServices {
    Logger logger = LogManager.getLogger(EmployeeServices.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=empData"+ ".csv";
        response.setHeader(headerKey, headerValue);
        List<Employee> listUsers = employeeRepository.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"empId","name","loc"};
        String[] nameMapping = {"empId","name","loc"};

        csvWriter.writeHeader(csvHeader);

        for (Employee employee : listUsers) {
            csvWriter.write(employee, nameMapping);

        }
        csvWriter.close();
        return listUsers;
    }
//    @Scheduled(fixedDelay = 5000)
    public List<Employee> getEmpData() throws IOException, SQLException {
         logger.debug("This is a debug message");
         logger.info("This is an info message");
         logger.error("This is an error message");
         logger.fatal("This is a fatal message");
//        System.out.println(
//                "Fixed delay task - " + System.currentTimeMillis() / 1000);
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

    public List<Employee> getByName(String name){
        return employeeRepository.findByName(name);
    }
    public Optional<Employee> getById(int emp_id){
         Optional<Employee> empData = employeeRepository.findById(emp_id);
//        Employee employee =  empData.get();

        return  employeeRepository.findById(emp_id);
    }

    public int longestCommonPrifix(){

        return 10;
    }

}

