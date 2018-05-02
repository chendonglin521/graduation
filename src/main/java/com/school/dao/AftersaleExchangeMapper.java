package com.school.dao;

import com.school.entity.AftersaleExchange;

public interface AftersaleExchangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AftersaleExchange record);

    int insertSelective(AftersaleExchange record);

    AftersaleExchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AftersaleExchange record);

    int updateByPrimaryKey(AftersaleExchange record);
}