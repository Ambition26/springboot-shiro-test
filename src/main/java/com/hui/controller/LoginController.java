package com.hui.controller;

import com.hui.pojo.Account;
import com.hui.pojo.Role;
import com.hui.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping({"/login", "/"})
    public String showIndex() {
        return "login";
    }

    @PostMapping(value = {"/tologin"})
    public String tologin(Account account, Model model) {
        System.out.println("当前登录账号：" + account);
        //1.获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(account.getUsername(), account.getPassword());
        try {
            subject.login(token);//执行登录,没有异常，说明ok
            return "redirect:/sys/showview";
        } catch (UnknownAccountException ex) {//用户名不存在
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException ex) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @RequestMapping("/sys/showview")
    public String showView() {
        //1.获取当前用户
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        //根据角色进入不同的界面
        Role role = userService.findRoleByAccountName(account.getUsername());
        if ("admin".equals(role.getRoleType())) {
            return "view/admin";
        } else if ("user".equals(role.getRoleType())) {
            return "view/user";
        } else if ("company".equals(role.getRoleType())) {
            return "view/company";
        } else {
            return "";
        }
    }

    /**
     * 无权限错误界面
     *
     * @return
     */
    @RequestMapping("/noauth")
    public String noauth() {
        return "/error/401";
    }

    @RequestMapping("/sys/logout")
    public String logout() {
        //1.获取当前用户
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
