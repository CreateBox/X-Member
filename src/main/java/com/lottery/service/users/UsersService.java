package com.lottery.service.users;

import com.lottery.pojo.Users;

public interface UsersService {
    Users getUser(Users users);

    int alterUser(Users users);
}
