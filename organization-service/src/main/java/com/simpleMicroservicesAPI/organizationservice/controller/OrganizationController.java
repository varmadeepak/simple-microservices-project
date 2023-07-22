package com.simpleMicroservicesAPI.organizationservice.controller;

import com.simpleMicroservicesAPI.organizationservice.dto.OrganizationDTO;
import com.simpleMicroservicesAPI.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/organization")
public class OrganizationController {
    private OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody  OrganizationDTO organizationDTO){
        OrganizationDTO savedOrg = organizationService.createOrganization(organizationDTO);
        return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<OrganizationDTO> getByOrganizationCode(@PathVariable String code){
        OrganizationDTO organizationDTO = organizationService.getOrganizationByOrgCode(code);
        return new ResponseEntity<>(organizationDTO,HttpStatus.OK);
    }
}

