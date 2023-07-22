package com.simpleMicroservicesAPI.departmentservice.controller;

import com.simpleMicroservicesAPI.departmentservice.dto.DepartmentDTO;
import com.simpleMicroservicesAPI.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }


    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentByid(@PathVariable Long id){
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }

    @GetMapping("/code/{depcode}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable String depcode){
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(depcode);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }

}
