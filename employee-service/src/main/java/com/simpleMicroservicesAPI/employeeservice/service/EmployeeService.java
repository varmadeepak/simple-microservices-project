package com.simpleMicroservicesAPI.employeeservice.service;

import com.simpleMicroservicesAPI.employeeservice.dto.ApiResponseDTO;
import com.simpleMicroservicesAPI.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    ApiResponseDTO getEmployeeById(Long id);
}
