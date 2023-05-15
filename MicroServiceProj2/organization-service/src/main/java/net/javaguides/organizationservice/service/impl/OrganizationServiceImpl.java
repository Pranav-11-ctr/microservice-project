package net.javaguides.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.mapper.OrganizationMapper;
import net.javaguides.organizationservice.repository.OrganizationRepository;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization= OrganizationMapper.OrganizationDtoToOrganization(organizationDto);
        return OrganizationMapper.OrganizationToOrganizationDto(organizationRepository.save(organization));
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        System.out.println(organizationCode);
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
       // System.out.println(organization.getId());
        return OrganizationMapper.OrganizationToOrganizationDto(organization);
    }
}
