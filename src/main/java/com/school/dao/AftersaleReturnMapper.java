package com.school.dao;

import com.school.entity.AftersaleReturn;

public interface AftersaleReturnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AftersaleReturn record);

    int insertSelective(AftersaleReturn record);

    AftersaleReturn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AftersaleReturn record);

    int updateByPrimaryKey(AftersaleReturn record);
}