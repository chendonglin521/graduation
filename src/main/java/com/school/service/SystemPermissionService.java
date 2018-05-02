package com.school.service;

import com.school.dao.SystemPermissionMapper;
import com.school.entity.SystemPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chendonglin on 2018/5/1.
 */
@Service
public class SystemPermissionService {

    @Autowired
    private SystemPermissionMapper systemPermissionMapper;

    public List<SystemPermission> getPermissionByRoleid(int roleid){
        return systemPermissionMapper.getPermissionByRoleid(roleid);
    }
}
