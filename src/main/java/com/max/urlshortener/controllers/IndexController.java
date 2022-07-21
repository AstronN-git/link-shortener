package com.max.urlshortener.controllers;

import com.max.urlshortener.entities.Url;
import com.max.urlshortener.hash.Hash;
import com.max.urlshortener.services.UrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    private final UrlService urlService;

    @Value("${server-url}")
    private String websiteUrl;

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
        String createdUrlHash = Hash.hashLongToString(createdUrl.getId());
        model.addAttribute("websiteUrl", websiteUrl);
        model.addAttribute("created", true);
        model.addAttribute("createdUrl", createdUrlHash);
        return "index";
    }

    @GetMapping("/{shortened}")
    public RedirectView shortUrl (@PathVariable String shortened) {
        Long hashed = Hash.hashStringToLong(shortened);
        Url url = urlService.getById(hashed);
        return new RedirectView(url.getFullUrl());
    }
}
