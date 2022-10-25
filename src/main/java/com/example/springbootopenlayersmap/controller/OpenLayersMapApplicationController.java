package com.example.springbootopenlayersmap.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenLayersMapApplicationController {
    @GetMapping(value = "map")
    public String getMapVue(Model model) {
        model.addAttribute("lat", 40);
        model.addAttribute("lng", 25);
        return "index";
    }
}
