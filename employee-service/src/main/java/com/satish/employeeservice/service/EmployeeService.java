package com.satish.employeeservice.service;

import com.satish.employeeservice.dto.APIResponseDto;
import com.satish.employeeservice.dto.EmployeeDto;
import com.satish.employeeservice.dto.Packet;
import com.satish.employeeservice.entity.Employee;

import java.util.List;


public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    //    EmployeeDto findByName(String name);
    APIResponseDto findById(Long id);

    Packet<List<Employee>> getAllEmployee();
}
