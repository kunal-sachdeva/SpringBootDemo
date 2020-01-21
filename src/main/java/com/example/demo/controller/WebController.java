package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    @RequestMapping(value="/index")
    public String index(Model model){
        model.addAttribute("user", new User());
        return "index";
    }
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public String validate(@ModelAttribute("user") User user){
        ValidationService.validateUser(user);
        return "Welcome! You are logged in";
    }
}
