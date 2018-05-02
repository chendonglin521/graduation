package com.school.dao;

import com.school.entity.SystemRole;
import com.school.entity.SystemUserRoleKey;

import java.util.List;

public interface SystemUserRoleMapper {
    int deleteByPrimaryKey(SystemUserRoleKey key);

    int insert(SystemUserRoleKey record);

    int insertSelective(SystemUserRoleKey record);

    List<Integer> getRoles(int userid);

}