package ru.redcollar.autoservice.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @Autowired
    public MainController() {
    }

    @GetMapping("/")
    public String greeting(Model model) {
        return "index";
    }
}
