package com.jili.hadmin.controller;

import com.jili.hadmin.constant.URL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 前端页面
 */
@Controller
public class FrontController {

    @GetMapping(value = "admin")
    public String index(){
        return URL.ADMIN;
    }
    @GetMapping(value = "login")
    public String login(HttpServletRequest request){
        request.setAttribute("title","猫掌柜后台");
        request.setAttribute("desc","用户管理人脸识别设备的系统");
        return URL.LOGIN;
    }

    @GetMapping(value = "about")
    public String about(){
        return URL.ABOUT;
    }

    @GetMapping(value = "error")
    public String error(){
        return URL.ERROR;
    }

    @GetMapping(value = "console")
    public String console(){
        return URL.CONSOLE;
    }

    @GetMapping(value = "register")
    public String register(HttpServletRequest request){
        request.setAttribute("title","猫掌柜后台");
        request.setAttribute("desc","用户管理人脸识别设备的系统");
        request.setAttribute("agreement","《猫掌柜用户注册协议》");
        return URL.REGISTER;
    }

    @GetMapping(value = "forgot")
    public String forgot(){
        return URL.FORGOT;
    }

    @GetMapping(value = "home")
    public String home(){
        return URL.HOME;
    }

    @GetMapping(value = "lmenu")
    public String lmenu(){
        return URL.LMENU;
    }

    @GetMapping(value = "treetable")
    public String treetable(){
        return URL.TREETABLE;
    }

    @GetMapping(value = "treeselect")
    public String treeselect(){
        return URL.TREESELECT;
    }

    @GetMapping(value = "add")
    public String add(){
        return URL.ADD;
    }

    /**
     *  文档
     */
    @GetMapping(value = "changelog")
    public String changelog(){
        return URL.CHANGELOG;
    }

    @GetMapping(value = "license")
    public String license(){
        return URL.LICENSE;
    }

    @GetMapping(value = "menu")
    public String menu(){
        return URL.MENU;
    }

    @GetMapping(value = "other")
    public String other(){
        return URL.OTHER;
    }

    @GetMapping(value = "quickstart")
    public String quickstart(){
        return URL.QUICKSTART;
    }

    @GetMapping(value = "tabs")
    public String tabs(){
        return URL.TABS;
    }

}
