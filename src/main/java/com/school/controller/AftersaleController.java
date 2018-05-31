package com.school.controller;

import com.school.entity.AftersaleExchange;
import com.school.entity.AftersaleRepair;
import com.school.entity.AftersaleReturn;
import com.school.service.AfterSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chendonglin on 2018/5/13.
 */
@RequestMapping("/after")
@Controller
public class AftersaleController {

    @Autowired
    private AfterSaleService afterSaleService;

    @RequestMapping("/returnIndex")
    public String afterReturn(){
        return "return";
    }
    @RequestMapping("/repairIndex")
    public String AfterRepair(){
        return "repair";
    }
    @RequestMapping("/exchangeIndex")
    public String afterExchange(){
        return "exchange";
    }

    @ResponseBody
    @RequestMapping("/return")
    public List<AftersaleReturn> getReturns(){
        return afterSaleService.getReturns();
    }
    @ResponseBody
    @RequestMapping("/repair")
    public List<AftersaleRepair> getRepairs(){
        return afterSaleService.getRepairs();
    }

    @ResponseBody
    @RequestMapping("/repairDelete/{id}")
    public void repairDelete(@PathVariable("id") int id){
        afterSaleService.repairDelete(id);
    }

    @ResponseBody
    @RequestMapping("/exchangeDelete/{id}")
    public void exchangeDelete(@PathVariable("id") int id){
        afterSaleService.exchangeDelete(id);
    }
    @ResponseBody
    @RequestMapping("/returnDelete/{id}")
    public void returnDelete(@PathVariable("id") int id){
        afterSaleService.returnDelete(id);
    }
    @ResponseBody
    @RequestMapping("/exchange")
    public List<AftersaleExchange> getExchanges(){
        return afterSaleService.getExchanges();
    }


}
