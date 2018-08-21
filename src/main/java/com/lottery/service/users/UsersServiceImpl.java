package com.lottery.service.users;

import com.lottery.mapper.UsersMapper;
import com.lottery.pojo.Users;
import com.lottery.service.users.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public Users getUser(Users users) {
        Users newUser = usersMapper.getUser(users);
        return newUser;
    }

    @Override
    @Transactional
    public int alterUser(Users users) {
        return usersMapper.alterUser(users);
    }
}
