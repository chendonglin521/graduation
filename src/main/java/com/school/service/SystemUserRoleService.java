package com.school.service;

import com.school.dao.SystemUserRoleMapper;
import com.school.entity.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chendonglin on 2018/4/26.
 */
@Service
public class SystemUserRoleService {

    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    public List<Integer> getRoles(int userid){
        return systemUserRoleMapper.getRoles(userid);
    }

}
