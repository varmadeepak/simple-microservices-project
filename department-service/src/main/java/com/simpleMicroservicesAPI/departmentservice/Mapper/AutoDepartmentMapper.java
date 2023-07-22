package com.simpleMicroservicesAPI.departmentservice.Mapper;

import com.simpleMicroservicesAPI.departmentservice.dto.DepartmentDTO;
import com.simpleMicroservicesAPI.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoDepartmentMapper {
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);
    DepartmentDTO mapDepartmentDTO (Department department);
    Department mapDepartment(DepartmentDTO departmentDTO);

}
