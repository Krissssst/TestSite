package com.example.TestProger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "name");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Страница про нас ");
        return "about";
    }
    @GetMapping("/reg")
    public String reg(Model model) {
        return "reg";
    }
    @GetMapping("/auth")
    public String auth(Model model) {
        return "auth";
    }

}
