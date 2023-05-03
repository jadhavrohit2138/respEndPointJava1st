package com.SecondProj.SecondProj.repository;

import com.SecondProj.SecondProj.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer>{

//    @Query("select name from emp  where name like CONCAT('%', :username, '%')")
//    List<Employee> findByPlaceContaining(@Param("username")String username);


    public List<Employee> findByName(String name);


}

