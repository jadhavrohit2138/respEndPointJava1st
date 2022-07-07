package com.SecondProj.SecondProj.repository;

import com.SecondProj.SecondProj.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer>{
}

