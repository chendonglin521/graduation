package com.school.service;

import com.school.dao.SystemUserMapper;
import com.school.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chendonglin on 2018/4/26.
 */
@Service
public class SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    public SystemUser selectByUsername(String username){
        return systemUserMapper.selectByUsername(username);
    }

    public List<SystemUser> listUsers(){
        return systemUserMapper.listUsers();
    }

}
