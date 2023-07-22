package com.simpleMicroservicesAPI.employeeservice.Mapper;

import com.simpleMicroservicesAPI.employeeservice.dto.EmployeeDTO;
import com.simpleMicroservicesAPI.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDTO mapEmployeeDTO(Employee employee);

    Employee mapEmployee(EmployeeDTO employeeDTO);
}
