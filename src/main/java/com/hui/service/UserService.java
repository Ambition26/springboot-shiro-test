package com.hui.service;

import com.hui.pojo.Account;
import com.hui.pojo.AccountPerm;
import com.hui.pojo.Role;

import java.util.Set;

public interface UserService {

    Account findAccountByName(String username);

    Role findRoleByAccountName(String username);

    Set<String> findAccountPerById(Integer accountId);
}
