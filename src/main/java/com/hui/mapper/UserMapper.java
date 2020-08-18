package com.hui.mapper;

import com.hui.pojo.Account;
import com.hui.pojo.AccountPerm;
import com.hui.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface UserMapper {
    /**
     * 登录验证 根据名称查找账号
     *
     * @param username
     * @return
     */
    Account findAccountByName(String username);
    /**
     * 根据名称查找账号角色
     *
     * @param username
     * @return
     */
    Role findRoleByAccountName(String username);
    /**
     * 根据账号编号查找账号权限
     *
     * @param accountId
     * @return set集合
     */
    Set<String> findAccountPerById(Integer accountId);
}
