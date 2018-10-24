package com.salesforce.keenaspace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SeatingController {

    @RequestMapping("/welcome")
    public String getWelcome(){
        return "welcome";
    }

    @RequestMapping("/")
    public String getHello(){
        return "hello";
    }

}
