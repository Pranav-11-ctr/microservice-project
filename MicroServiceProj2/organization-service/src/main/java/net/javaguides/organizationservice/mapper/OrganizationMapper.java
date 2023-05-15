package net.javaguides.organizationservice.mapper;

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static Organization  OrganizationDtoToOrganization(OrganizationDto organizationDto)
    {
        Organization organization=new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate());
//        organization.setId(organizationDto.getId());
//        organization.setOrganizationName(organizationDto.getOrganizationName());
//        organization.setOrganizationCode(organizationDto.getOrganizationCode());
//        organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
//        organization.setCreatedDate(organizationDto.getCreatedDate());

        return organization;
    }

    public static OrganizationDto  OrganizationToOrganizationDto(Organization organization)
    {
        OrganizationDto organizationDto=new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
//        organizationDto.setId(organization.getId());
//        organizationDto.setOrganizationName(organization.getOrganizationName());
//        organizationDto.setOrganizationCode(organization.getOrganizationCode());
//        organizationDto.setOrganizationDescription(organization.getOrganizationDescription());
//        organizationDto.setCreatedDate(organization.getCreatedDate());

        return organizationDto;
    }
}
