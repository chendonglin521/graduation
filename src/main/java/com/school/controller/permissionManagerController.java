package com.school.controller;

import com.school.entity.SystemPermission;
import com.school.service.SystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chendonglin on 2018/5/1.
 */
@Controller
public class permissionManagerController {

    @Autowired
    private SystemPermissionService systemPermissionService;

    @RequestMapping("/permission/index")
    public String index(){

        return "permissionManager";
    }

    @ResponseBody
    @RequestMapping("/permission/data")
    public List<SystemPermission> listPermissions(){
       return systemPermissionService.listPermissions();
    }

}
