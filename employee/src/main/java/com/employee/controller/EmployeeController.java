package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.model.dto.AddressDto;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws EmployeeException{

        Employee employee1 = employeeService.addEmployee(employee);

        return new ResponseEntity<Employee>(employee1, HttpStatus.CREATED);

    }

    @GetMapping("/employees/")
    public ResponseEntity<List<Employee>> getListOfEmployee() throws EmployeeException{

        List<Employee> list = employeeService.getListOfEmployee();

        return new ResponseEntity<List<Employee>>(list,HttpStatus.ACCEPTED);

    }

    @PatchMapping("/employee/")
    public ResponseEntity<Boolean> updateEmployeeAddress(@RequestBody AddressDto addressDto) throws EmployeeException{

        boolean b = employeeService.updateEmployeeAddress(addressDto);

        return new ResponseEntity<Boolean>(b, HttpStatus.ACCEPTED);

    }

    @GetMapping("/employee/")
    public ResponseEntity<List<Employee>> getEemployeeByPincode(@RequestParam("pincode") Integer pincode) throws EmployeeException{

        List<Employee> list = employeeService.getListByPincode(pincode);

        return new ResponseEntity<List<Employee>>(list,HttpStatus.ACCEPTED);

    }

    @PatchMapping("/employee/updateByS/")
    public ResponseEntity<List<Employee>> getByNameLike(@RequestParam("age") Integer age) throws EmployeeException{

        List<Employee> list = employeeService.updateEmployeeBasedOnName(age);

        return new ResponseEntity<List<Employee>>(list,HttpStatus.ACCEPTED);

    }

}
