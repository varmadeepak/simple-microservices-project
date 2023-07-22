package com.simpleMicroservicesAPI.departmentservice.service;

import com.simpleMicroservicesAPI.departmentservice.Exception.ResourceNotFoundException;
import com.simpleMicroservicesAPI.departmentservice.Mapper.AutoDepartmentMapper;
import com.simpleMicroservicesAPI.departmentservice.dto.DepartmentDTO;
import com.simpleMicroservicesAPI.departmentservice.entity.Department;
import com.simpleMicroservicesAPI.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
//        Department department  = new Department(
//                departmentDTO.getId(),
//                departmentDTO.getDepartmentName(),
//                departmentDTO.getDepartmentDescription(),
//                departmentDTO.getDepartmentCode()
//        );
        Department department = AutoDepartmentMapper.MAPPER.mapDepartment(departmentDTO);
        Department createdDepartment = departmentRepository.save(department);
//        DepartmentDTO savedDepartment = new DepartmentDTO(
//                createdDepartment.getId(),
//                createdDepartment.getDepartmentName(),
//                createdDepartment.getDepartmentDescription(),
//                createdDepartment.getDepartmentCode()
//        );
        return AutoDepartmentMapper.MAPPER.mapDepartmentDTO(createdDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Department","Id",id)
        );
//        DepartmentDTO fethcedDepartment = new DepartmentDTO(
//          department.getId(),
//          department.getDepartmentName(),
//          department.getDepartmentName(),
//          department.getDepartmentCode()
//        );

        return AutoDepartmentMapper.MAPPER.mapDepartmentDTO(department);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department  = departmentRepository.findByDepartmentCode(departmentCode);
//        DepartmentDTO departmentDTO = new DepartmentDTO(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );

        DepartmentDTO departmentDTO = AutoDepartmentMapper.MAPPER.mapDepartmentDTO(department);
//        DepartmentDTO departmentDTO = new DepartmentDTO(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
        return departmentDTO;
    }
}
