package com.manager.service.role;

import com.manager.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> roleList(Role role);

    int count(Role role);
}
