package com.simpleMicroservicesAPI.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class OrganizationDTO {
    private Long id;
    private String organizationName;
    private String organizationCode;
    private String organizationDescription;

    public OrganizationDTO(){

    }
    public OrganizationDTO(Long id, String organizationName, String organizationCode, String organizationDescription) {
        this.id = id;
        this.organizationName = organizationName;
        this.organizationCode = organizationCode;
        this.organizationDescription = organizationDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }
}
