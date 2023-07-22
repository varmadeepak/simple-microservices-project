package com.simpleMicroservicesAPI.employeeservice.controller;

import com.simpleMicroservicesAPI.employeeservice.dto.ApiResponseDTO;
import com.simpleMicroservicesAPI.employeeservice.dto.EmployeeDTO;
import com.simpleMicroservicesAPI.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> getEmployeeById(@PathVariable Long id){
        ApiResponseDTO fetchedEmployee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(fetchedEmployee,HttpStatus.OK);
    }
}
