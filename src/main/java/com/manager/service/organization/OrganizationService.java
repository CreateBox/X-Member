package com.manager.service.organization;

import com.manager.pojo.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> organizationList(Integer begin, Integer end, Organization organization);

    int count(Organization organization);

    Organization getOrganization(Organization organization);

    int modifyOrganization(Organization organization);

    int validationOrganization(Organization organization);

    int delOrganization(Organization organization);
}
