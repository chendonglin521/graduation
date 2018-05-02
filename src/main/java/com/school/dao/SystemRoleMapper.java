package com.school.dao;

import com.school.entity.SystemRole;

import java.util.List;

public interface SystemRoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    SystemRole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(SystemRole record);

    int updateByPrimaryKey(SystemRole record);

    List<SystemRole> listRoles();
}