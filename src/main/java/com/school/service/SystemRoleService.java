package com.school.service;

import com.school.dao.SystemRoleMapper;
import com.school.entity.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chendonglin on 2018/5/1.
 */
@Service
public class SystemRoleService {

    @Autowired
    private SystemRoleMapper roleMapper;

    public List<SystemRole> listRoles(){
        return roleMapper.listRoles();
    }
}
