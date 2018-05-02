package com.school.dao;

import com.school.entity.AftersaleRepair;

public interface AftersaleRepairMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AftersaleRepair record);

    int insertSelective(AftersaleRepair record);

    AftersaleRepair selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AftersaleRepair record);

    int updateByPrimaryKey(AftersaleRepair record);
}