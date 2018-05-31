package com.school.dao;

import com.school.entity.AftersaleExchange;

import java.util.List;

public interface AftersaleExchangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AftersaleExchange record);

    int insertSelective(AftersaleExchange record);

    AftersaleExchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AftersaleExchange record);

    int updateByPrimaryKey(AftersaleExchange record);

    List<AftersaleExchange> getExchanges();
}