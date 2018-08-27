package com.manager.service.organization;

import com.manager.mapper.OrganizationMapper;
import com.manager.pojo.Organization;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public List<Organization> organizationList(Integer begin, Integer end, Organization organization) {
        Map<String,Object> map = new HashMap<>();
        map.put("begin",begin);
        map.put("end",end);
        map.put("organization",organization);
        return organizationMapper.organizationList(map);
    }

    @Override
    public int count(Organization organization) {
        return organizationMapper.count(organization);
    }

    @Override
    public Organization getOrganization(Organization organization) {
        return organizationMapper.getOrganization(organization);
    }

    @Override
    public int modifyOrganization(Organization organization) {
        return organizationMapper.modifyOrganization(organization);
    }

    @Override
    public int validationOrganization(Organization organization) {
        return organizationMapper.validationOrganization(organization);
    }

    @Override
    public int delOrganization(Organization organization) {
        return organizationMapper.delOrganization(organization);
    }
}
