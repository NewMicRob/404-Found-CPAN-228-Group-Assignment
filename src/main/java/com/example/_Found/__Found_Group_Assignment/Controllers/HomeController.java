package com.example._Found.__Found_Group_Assignment.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
