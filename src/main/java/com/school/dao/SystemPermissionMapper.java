package com.school.dao;

import com.school.entity.SystemPermission;

import java.util.List;

public interface SystemPermissionMapper {
    int deleteByPrimaryKey(Integer permissionid);

    int insert(SystemPermission record);

    int insertSelective(SystemPermission record);

    SystemPermission selectByPrimaryKey(Integer permissionid);

    int updateByPrimaryKeySelective(SystemPermission record);

    int updateByPrimaryKey(SystemPermission record);
    List<SystemPermission> getPermissionByRoleid(int roleid);

    List<SystemPermission> listPermissions();
}