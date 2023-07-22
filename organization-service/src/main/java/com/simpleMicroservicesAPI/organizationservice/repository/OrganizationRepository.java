package com.simpleMicroservicesAPI.organizationservice.repository;

import com.simpleMicroservicesAPI.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String orgCode);
}
