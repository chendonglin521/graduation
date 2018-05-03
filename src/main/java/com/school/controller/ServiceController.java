package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chendonglin on 2018/5/2.
 */
@Controller
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping("/agreement")
    public String serviceAgreement(){
        return "serviceAgreement";
    }

}
