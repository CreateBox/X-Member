package com.manager.mapper;

import com.manager.pojo.Organization;

import java.util.List;
import java.util.Map;

public interface OrganizationMapper {
    List<Organization> organizationList(Map map);

    int count(Organization organization);

    Organization getOrganization(Organization organization);

    int modifyOrganization(Organization organization);

    int validationOrganization(Organization organization);

    int delOrganization(Organization organization);
}
