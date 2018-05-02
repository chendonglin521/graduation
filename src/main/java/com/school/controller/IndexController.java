package com.school.controller;

import com.school.common.BaseResult;
import com.school.common.ResultConstant;
import com.school.service.SystemUserRoleService;
import com.school.service.SystemUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by chendonglin on 2018/4/25.
 */
@Controller
public class IndexController {

    @Autowired
    private SystemUserService userService;

    @Autowired
    private SystemUserRoleService systemUserRoleService;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/crud")
    public String curd() {
        return "crud";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean rememberMe = Boolean.valueOf(request.getParameter("rememberMe"));
        if (StringUtils.isEmpty(username)) {
            return new BaseResult(ResultConstant.EMPTY_USERNAME.code, "帐号不能为空！", "");
        }
        if (StringUtils.isEmpty(password)) {
            return new BaseResult(ResultConstant.EMPTY_PASSWORD.code, "密码不能为空！", "");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            if (rememberMe) {
                usernamePasswordToken.setRememberMe(true);
            } else {
                usernamePasswordToken.setRememberMe(false);
            }
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            return new BaseResult(ResultConstant.INVALID_USERNAME.code, "帐号不存在！", "帐号不存在！");
        } catch (IncorrectCredentialsException e) {
            return new BaseResult(ResultConstant.INVALID_PASSWORD.code, "密码错误！", "密码错误！");
        } catch (LockedAccountException e) {
            return new BaseResult(ResultConstant.INVALID_ACCOUNT.code, "帐号已锁定！", "帐号已锁定！");
        }
        return new BaseResult(ResultConstant.SUCCESS.code, "登录成功！", "/index");
    }

    @RequestMapping("/index")
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        String username = subject.getPrincipal().toString();
        int userid = userService.selectByUsername(username).getUserid();

        List<Integer> roles = systemUserRoleService.getRoles(userid);
        model.addAttribute("roles",roles);
        model.addAttribute("username",username);
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        // shiro退出登录
        SecurityUtils.getSubject().logout();
        // 跳回原地址
        String redirectUrl = request.getHeader("Referer");
        if (null == redirectUrl) {
            redirectUrl = "/";
        }
        return "redirect:" + redirectUrl;
    }
}
