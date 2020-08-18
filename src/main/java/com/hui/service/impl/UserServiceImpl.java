package com.hui.service.impl;

import com.hui.mapper.UserMapper;
import com.hui.pojo.Account;
import com.hui.pojo.AccountPerm;
import com.hui.pojo.Role;
import com.hui.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Account findAccountByName(String username) {
        return userMapper.findAccountByName(username);
    }

    @Override
    public Role findRoleByAccountName(String username) {
        return userMapper.findRoleByAccountName(username);
    }

    @Override
    public Set<String> findAccountPerById(Integer accountId) {
        return userMapper.findAccountPerById(accountId);
    }


}
