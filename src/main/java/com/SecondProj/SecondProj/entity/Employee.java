package com.SecondProj.SecondProj.entity;

import javax.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {

    public Employee(int empId, String name, int compId) {
        this.empId = empId;
        this.name = name;
        this.compId = compId;
    }

    public Employee() {
        super();
    }

    @Id
    @Column(name = "empId")
    private int empId;
    @Column(name = "name")
    private String name;
    @Column(name = "compId")
    private int compId;

    public int getEmp_id() {
        return empId;
    }

    public void setEmp_id(int empId) {
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