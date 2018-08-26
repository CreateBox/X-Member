package com.manager.service.role;

import com.manager.mapper.RoleMapper;
import com.manager.pojo.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> roleList(Role role,Integer begin,Integer end) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("role",role);
        map.put("begin",begin);
        map.put("end",end);
        return roleMapper.roleList(map);
    }

    @Override
    public int count(Role role) {
        return roleMapper.count(role);
    }

    @Override
    public Role getRole(Role role) {
        return roleMapper.getRole(role);
    }

    @Override
    public List<Role> roleAll() {
        return roleMapper.roleAll();
    }

    @Override
    @Transactional
    public int modify(Role role) {
        return roleMapper.modify(role);
    }

    @Override
    @Transactional
    public int delRole(Role role) {
        return roleMapper.delRole(role);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public int validationRole(Role role) {
        return roleMapper.validationRole(role);
    }
}
