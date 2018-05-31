package com.school.service;

import com.school.dao.AftersaleExchangeMapper;
import com.school.dao.AftersaleRepairMapper;
import com.school.dao.AftersaleReturnMapper;
import com.school.entity.AftersaleExchange;
import com.school.entity.AftersaleRepair;
import com.school.entity.AftersaleReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chendonglin on 2018/5/13.
 */
@Service
public class AfterSaleService {

    @Autowired
    private AftersaleReturnMapper returnMapper;

    @Autowired
    private AftersaleExchangeMapper exchangeMapper;

    @Autowired
    private AftersaleRepairMapper repairMapper;


    public List<AftersaleReturn> getReturns(){
        return returnMapper.getReturns();
    }

    public List<AftersaleRepair> getRepairs(){
        return repairMapper.getRepairs();
    }

    public List<AftersaleExchange> getExchanges(){
        return exchangeMapper.getExchanges();
    }

    public void repairDelete(int id) {
        repairMapper.deleteByPrimaryKey(id);
    }

    public void exchangeDelete(int id) {
        exchangeMapper.deleteByPrimaryKey(id);
    }

    public void returnDelete(int id) {
        returnMapper.deleteByPrimaryKey(id);
    }
}
