package com.school.service;

import com.school.dao.UlockOperatorMapper;
import com.school.entity.UlockApplication;
import com.school.entity.UlockOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chendonglin on 2018/4/24.
 */
@Service
public class UlockOperatorService {

    @Autowired
    private UlockOperatorMapper ulockOperatorMapper;

    public int deleteByPrimaryKey(Long id) {
        return ulockOperatorMapper.deleteByPrimaryKey(id);
    }

    public UlockOperator selectByPrimaryKey(Long id){
        return ulockOperatorMapper.selectByPrimaryKey(id);
    }

    public void updateByPrimaryKey(UlockOperator record){
        ulockOperatorMapper.updateByPrimaryKey(record);
    }
    public void updateByPrimaryKeySelective(UlockOperator record){
        ulockOperatorMapper.updateByPrimaryKeySelective(record);
    }
    public void insertSelective(UlockOperator record){
        ulockOperatorMapper.insertSelective(record);
    }

}
