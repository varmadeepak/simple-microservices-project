package com.simpleMicroservicesAPI.organizationservice.service;

import com.simpleMicroservicesAPI.organizationservice.dto.OrganizationDTO;
public interface OrganizationService {

    OrganizationDTO createOrganization(OrganizationDTO organizationDTO);

    OrganizationDTO getOrganizationByOrgCode(String code);
}
