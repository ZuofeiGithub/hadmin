package com.jili.hadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping(value = "admin")
    public String index(){
        return "index.html";
    }

    @GetMapping(value = "login")
    public String login(){
        return "login.html";
    }
}
