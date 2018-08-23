package com.manager.service.users;

import com.manager.pojo.Users;

public interface UsersService {
    Users getUser(Users users);

    int alterUser(Users users);
}
