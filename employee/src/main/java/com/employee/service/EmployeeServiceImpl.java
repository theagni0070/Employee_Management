package com.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.model.dto.AddressDto;
import com.employee.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee addEmployee(Employee employee) throws EmployeeException {

        return employeeDao.save(employee);

    }

    @Override
    public List<Employee> getListOfEmployee() throws EmployeeException {

        List<Employee> list = employeeDao.findAll();

        if(list.isEmpty()) throw new EmployeeException("The List is empty please add some Employee");

        return list;
    }

    @Override
    public List<Employee> getListByPincode(Integer pincode) throws EmployeeException {

        List<Employee> list = employeeDao.findByPincode(pincode);

        if(list.isEmpty()) throw new EmployeeException("Invalid Pincode");

        return list;

    }

    @Override
    public boolean updateEmployeeAddress(AddressDto addressDto) throws EmployeeException {

        Employee employee = employeeDao.findById(addressDto.getEmployeeId()).orElseThrow(() -> new EmployeeException("Invalid Employee Id"));

        employee.setEmployeeAddress(addressDto.getAddress());

        employeeDao.save(employee);

        return true;

    }

    @Override
    public List<Employee> updateEmployeeBasedOnName(Integer age) throws EmployeeException {

        List<Employee> list = employeeDao.findByNameLike();

        if(list.isEmpty()) throw new EmployeeException("Please enter valid command");

        for(Employee emp:list){

            emp.setEmployeeAge(age);
            employeeDao.save(emp);

        }

        return employeeDao.findByNameLike();
    }
    
}
