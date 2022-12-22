package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Long>{
    
    @Query("FROM Employee e JOIN e.employeeAddress a WHERE a.pinCode=:pincode")
    public List<Employee> findByPincode(Integer pincode);

    @Query("FROM Employee e WHERE e.employeeName LIKE 'S%'")
    public List<Employee> findByNameLike();

}
