package com.satish.employeeservice.service.impl;

import com.satish.employeeservice.dto.APIResponseDto;
import com.satish.employeeservice.dto.DepartmentDto;
import com.satish.employeeservice.dto.EmployeeDto;
import com.satish.employeeservice.dto.Packet;
import com.satish.employeeservice.entity.Employee;
import com.satish.employeeservice.repository.EmployeeRepository;
import com.satish.employeeservice.service.APIClient;
import com.satish.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    //private RestTemplate restTemplate
//    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        //Employee dto to entity
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

//    @Override
//    public EmployeeDto findByName(String name) {
//        Employee employee = employeeRepository.findByEmployeeName(name);
//
//        //convert Employee to EmployeeDTo
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
//
//        return employeeDto;
//    }

    @Override
    public APIResponseDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity
//                ("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();
//        System.out.println(responseEntity);
//        System.out.println(departmentDto);

        System.out.println(employee.getDepartmentCode());
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                //for synchronous call
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        System.out.println(departmentDto.getDepartmentCode());

        //convert Employee to EmployeeDTo
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        System.out.println(employeeDto);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    public Packet<List<Employee>> getAllEmployee() {
        List<Employee> allEmployee = employeeRepository.findAll();
        return new Packet<>("OK","All employee",allEmployee);
    }
}
