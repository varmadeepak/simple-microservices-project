package com.simpleMicroservicesAPI.organizationservice.Mapper;

import com.simpleMicroservicesAPI.organizationservice.dto.OrganizationDTO;
import com.simpleMicroservicesAPI.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDTO mapOrganizationDTO(Organization organization){
        OrganizationDTO organizationDTO = new OrganizationDTO(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationCode(),
                organization.getOrganizationDescription()
        );
        return organizationDTO;
    }
    public static Organization mapOrganization(OrganizationDTO organizationDTO){
        Organization organization = new Organization(
                organizationDTO.getId(),
                organizationDTO.getOrganizationName(),
                organizationDTO.getOrganizationCode(),
                organizationDTO.getOrganizationDescription()
        );
        return organization;
    }
}
