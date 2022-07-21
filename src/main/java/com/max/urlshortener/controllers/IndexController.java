package com.max.urlshortener.controllers;

import com.max.urlshortener.entities.Url;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("url", new Url());
        return "index";
    }
}
