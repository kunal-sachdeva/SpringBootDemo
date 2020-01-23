package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.ProductStore;
import com.example.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    @Autowired
    ProductStore productStore;

    @RequestMapping(value = "/")
    public String Hello(){
        return "home";
    }

    @RequestMapping(value="/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }

}
