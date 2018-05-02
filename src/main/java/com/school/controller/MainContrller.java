package com.school.controller;

import com.school.entity.UlockOperator;
import com.school.service.UlockOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chendonglin on 2018/4/24.
 */
@RestController
public class MainContrller {

    @Autowired
    private UlockOperatorService ulockOperatorService;


    @ResponseBody
    @RequestMapping("/id")
    public UlockOperator getUnlock(@RequestParam("id") long id){

        return null;
//        return ulockOperatorService.selectByPrimaryKey(id);
    }
}
