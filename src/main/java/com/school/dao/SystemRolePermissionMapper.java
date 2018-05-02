package com.school.dao;

import com.school.entity.SystemRolePermissionKey;

public interface SystemRolePermissionMapper {
    int deleteByPrimaryKey(SystemRolePermissionKey key);

    int insert(SystemRolePermissionKey record);

    int insertSelective(SystemRolePermissionKey record);
}