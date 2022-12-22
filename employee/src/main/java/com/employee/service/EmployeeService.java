package com.employee.service;

import java.util.List;
import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.model.dto.AddressDto;

public interface EmployeeService {
    
    public Employee addEmployee(Employee employee) throws EmployeeException;

    public List<Employee> getListOfEmployee() throws EmployeeException;

    public List<Employee> getListByPincode(Integer pincode) throws EmployeeException;

    public boolean updateEmployeeAddress(AddressDto addressDto) throws EmployeeException;

    public List<Employee> updateEmployeeBasedOnName(Integer age) throws EmployeeException;

}
