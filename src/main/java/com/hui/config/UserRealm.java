package com.hui.config;

import com.hui.pojo.Account;
import com.hui.pojo.Role;
import com.hui.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 继承AuthorizingRealm
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了==》》授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取到当前用户
        Account account = (Account) principalCollection.getPrimaryPrincipal();

        //赋予用户角色
        Role role = userService.findRoleByAccountName(account.getUsername());
        Set<String> roleSet = new HashSet<String>();
        roleSet.add(role.getRoleType());
        info.setRoles(roleSet);
        //赋予用户权限
        Set<String> permSet = new HashSet<String>();
        permSet = userService.findAccountPerById(account.getId());
        System.out.println("账户权限：" + permSet);
        info.setStringPermissions(permSet);
        return info;
    }

    /**
     * 认证
     *
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了==》》doGetAuthenticationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //用户名，密码，数据库中取
        Account account = userService.findAccountByName(userToken.getUsername());
        if (account == null) {
            return null;//用户名不存在
        }

        //获取session
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",account);

        //可以加密：md5，md5盐值加密
        //密码认证 shiro做   加密密码    这里传入数据库的密码，会自动判断
        return new SimpleAuthenticationInfo(account, account.getPassword(), this.getName());
    }
}
