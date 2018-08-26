package com.manager.service.role;

import com.manager.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> roleList(Role role,Integer begin,Integer end);

    int count(Role role);

    Role getRole(Role role);

    List<Role> roleAll();

    int modify(Role role);

    int delRole(Role role);

    int addRole(Role role);

    int validationRole(Role role);
}
