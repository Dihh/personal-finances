package com.dehhvs.personalfinance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCOntroller {

    @RequestMapping("/")
    public String index(ModelMap model) {
        return "index";
    }

}
