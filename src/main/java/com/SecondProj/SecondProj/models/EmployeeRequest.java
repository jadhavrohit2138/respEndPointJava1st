package com.SecondProj.SecondProj.models;

//import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonAnyGetter;

import javax.persistence.Id;

public class EmployeeRequest {
    @Id
    private Integer empId;
    private String name;
    private int compId;

    public EmployeeRequest(int empId, String name, int compId) {
        this.empId = empId;
        this.name = name;
        this.compId = compId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcomId() {
        return compId;
    }

    public void setcomId(int compId) {
        this.compId = compId;
    }
}
