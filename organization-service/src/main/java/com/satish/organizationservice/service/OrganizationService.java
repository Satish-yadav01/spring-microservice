package com.satish.organizationservice.service;

import com.satish.organizationservice.dto.OrganizationDto;
import org.springframework.stereotype.Service;


public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);

}
