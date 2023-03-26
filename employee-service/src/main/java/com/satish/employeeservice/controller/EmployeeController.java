package com.satish.employeeservice.controller;

import com.satish.employeeservice.dto.APIResponseDto;
import com.satish.employeeservice.dto.EmployeeDto;
import com.satish.employeeservice.dto.Packet;
import com.satish.employeeservice.entity.Employee;
import com.satish.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("api/employee")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Packet> saveEmployee(@RequestBody EmployeeDto employeeDto){
        try{
            EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
            return new ResponseEntity<>(new Packet("OK","Employee created",
                    savedEmployee), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(new Packet("Error","something went wrong :"+e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping(value = "/{name}")
//    public ResponseEntity<Packet> getEmployeeByName(@PathVariable("name") String name){
//        try{
//            EmployeeDto empNameDetails = employeeService.findByName(name);
//            return new ResponseEntity<>(new Packet<>("OK","employee details",
//                    empNameDetails),HttpStatus.OK);
//        }catch(Exception e){
//            return new ResponseEntity<>(new Packet<>("error","something went wrong :"+e.getMessage()
//                   ),HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id){
        try{
            APIResponseDto empDetails = employeeService.findById(id);
            return new ResponseEntity<>(empDetails,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Packet<>("error","something went wrong "
                    +e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Packet> getAllEmployee(){
        try{
            Packet<List<Employee>> allEmpDetails = employeeService.getAllEmployee();
            return new ResponseEntity<>(new Packet<>("OK","employee details",
                    allEmpDetails),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new Packet<>("error","something went wrong :"+e.getMessage()
            ),HttpStatus.NOT_FOUND);
        }
    }
}
