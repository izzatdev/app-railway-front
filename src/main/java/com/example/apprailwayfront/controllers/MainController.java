package com.example.apprailwayfront.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MainController {

    @GetMapping("home")
    public String goMainPage() {
        return "index";
    }
}
