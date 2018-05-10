package com.school.controller;

import com.school.entity.SystemUser;
import com.school.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chendonglin on 2018/5/1.
 */
@Controller
public class UserManagerController {

    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping("/user/index")
    public String index(){

        return "userManager";
    }

    @ResponseBody
    @RequestMapping("/user/data")
    public List<SystemUser> getRoles(){
       return systemUserService.listUsers();
    }

}
