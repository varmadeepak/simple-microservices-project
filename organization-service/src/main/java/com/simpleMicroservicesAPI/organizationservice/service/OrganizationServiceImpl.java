package com.simpleMicroservicesAPI.organizationservice.service;

import com.simpleMicroservicesAPI.organizationservice.Mapper.OrganizationMapper;
import com.simpleMicroservicesAPI.organizationservice.dto.OrganizationDTO;
import com.simpleMicroservicesAPI.organizationservice.entity.Organization;
import com.simpleMicroservicesAPI.organizationservice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO){
//        Organization organization = new Organization(
//                organizationDTO.getId(),
//                organizationDTO.getOrganizationName(),
//                organizationDTO.getOrganizationCode(),
//                organizationDTO.getOrganizationDescription()
//        );
        Organization organization = OrganizationMapper.mapOrganization(organizationDTO);
        Organization savedOrganization = organizationRepository.save(organization);
//        OrganizationDTO organizationDTO1 = new OrganizationDTO(
//                savedOrganization.getId(),
//                savedOrganization.getOrganizationName(),
//                savedOrganization.getOrganizationCode(),
//                savedOrganization.getOrganizationDescription()
//        );
        OrganizationDTO organizationDTO1 = OrganizationMapper.mapOrganizationDTO(savedOrganization);
        return organizationDTO1;
    }

    @Override
    public OrganizationDTO getOrganizationByOrgCode(String code) {
        Organization organization = organizationRepository.findByOrganizationCode(code);
        OrganizationDTO organizationDTO = OrganizationMapper.mapOrganizationDTO(organization);
        return organizationDTO;
    }
}
