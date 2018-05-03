package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chendonglin on 2018/5/2.
 */
@Controller
public class CommonController {

    @RequestMapping("/403")
    public String unauthorizedUrl(){
        return "403";
    }

    @RequestMapping("/404")
    public String notFound(){
        return "404";
    }

    @RequestMapping("/500")
    public String serverError(){
        return "500";
    }
}
