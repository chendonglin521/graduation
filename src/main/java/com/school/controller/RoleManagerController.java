package com.school.controller;

import com.school.dao.SystemRoleMapper;
import com.school.entity.SystemPermission;
import com.school.entity.SystemRole;
import com.school.service.SystemPermissionService;
import com.school.service.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chendonglin on 2018/5/1.
 */
@Controller
public class RoleManagerController {

    @Autowired
    private SystemRoleService roleService;

    @Autowired
    private SystemPermissionService systemPermissionService;

    @RequestMapping("/role/index")
    public String index(){

        return "roleManager";
    }

    @ResponseBody
    @RequestMapping("/role/data")
    public List<SystemRole> getRoles(){
       return roleService.listRoles();
    }

    @ResponseBody
    @RequestMapping("/role/permissions/{roleid}")
    public List<SystemPermission> getRoles(@PathVariable("roleid") int roleid){

        return systemPermissionService.getPermissionByRoleid(roleid);
    }
}
