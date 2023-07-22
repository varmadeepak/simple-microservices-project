package com.simpleMicroservicesAPI.departmentservice.service;

import com.simpleMicroservicesAPI.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentById(Long id);
    DepartmentDTO getDepartmentByCode(String departmentCode);
}
