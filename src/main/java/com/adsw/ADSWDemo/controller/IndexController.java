package com.adsw.ADSWDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class IndexController {

    @GetMapping("/index")
    public String index(
            @RequestParam(name="name", required = false, defaultValue = "ADSW") String name,
            Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}
