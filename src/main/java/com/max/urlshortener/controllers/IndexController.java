package com.max.urlshortener.controllers;

import com.max.urlshortener.entities.Url;
import com.max.urlshortener.services.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    private final UrlService urlService;

    public IndexController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("url", new Url());
        return "index";
    }

    @PostMapping("/")
    public String createUrl (@ModelAttribute Url url, Model model) {
        Url createdUrl = urlService.save(url);
        model.addAttribute("created", true);
        model.addAttribute("createdUrl", createdUrl);
        return "index";
    }
}
