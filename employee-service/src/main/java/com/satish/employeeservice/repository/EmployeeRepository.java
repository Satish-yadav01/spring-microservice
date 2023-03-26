package com.satish.employeeservice.repository;

import com.satish.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

//    Employee findByEmployeeName(String name);
}
