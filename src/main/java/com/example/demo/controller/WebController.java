package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {
    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/validate")
    @ResponseBody
    public String validate(){
        return "You are logged in";
    }
}
