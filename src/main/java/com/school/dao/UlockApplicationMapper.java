package com.school.dao;

import com.school.entity.UlockApplication;
import com.school.entity.UlockApplicationWithBLOBs;

import java.util.List;

public interface UlockApplicationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UlockApplicationWithBLOBs record);

    int insertSelective(UlockApplicationWithBLOBs record);

    UlockApplicationWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UlockApplicationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UlockApplicationWithBLOBs record);

    int updateByPrimaryKey(UlockApplication record);

    List<UlockApplication> selectByState(long state);
}