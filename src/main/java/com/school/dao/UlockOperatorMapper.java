package com.school.dao;

import com.school.entity.UlockOperator;

public interface UlockOperatorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UlockOperator record);

    int insertSelective(UlockOperator record);

    UlockOperator selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UlockOperator record);

    int updateByPrimaryKey(UlockOperator record);
}