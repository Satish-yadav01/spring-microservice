package com.satish.organizationservice.service.impl;

import com.satish.organizationservice.dto.OrganizationDto;
import com.satish.organizationservice.entity.Organization;
import com.satish.organizationservice.mapper.OrganizationMapper;
import com.satish.organizationservice.repository.OrganizationRepository;
import com.satish.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        //convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization saveOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(saveOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
