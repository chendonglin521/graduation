package com.school.dao;

import com.school.entity.SystemUser;

import java.util.List;

public interface SystemUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Integer userid);

    SystemUser selectByUsername(String username);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    List<SystemUser> listUsers();
}