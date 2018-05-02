package com.school.service;

import com.school.dao.UlockApplicationMapper;
import com.school.entity.UlockApplication;
import com.school.entity.UlockApplicationWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by chendonglin on 2018/4/24.
 */
@Service
public class UlockApplicationService {

    @Autowired
    private UlockApplicationMapper ulockApplicationMapper;


    public UlockApplicationWithBLOBs getApplication(long id){
        return  ulockApplicationMapper.selectByPrimaryKey(id);
    }

    public void insert(UlockApplicationWithBLOBs applicationWithBLOBs){
        String applicationId = UUID.randomUUID().toString();
        applicationWithBLOBs.setState(0);
        applicationWithBLOBs.setApplicationid(applicationId);
        applicationWithBLOBs.setCreateTime(System.currentTimeMillis());
        ulockApplicationMapper.insert(applicationWithBLOBs);
    }

    public List<UlockApplication> getApplicationByState(long state) {
        return ulockApplicationMapper.selectByState(state);
    }
    public void updateByPrimaryKeySelective(UlockApplicationWithBLOBs record){
        ulockApplicationMapper.updateByPrimaryKeySelective(record);
    }

}
