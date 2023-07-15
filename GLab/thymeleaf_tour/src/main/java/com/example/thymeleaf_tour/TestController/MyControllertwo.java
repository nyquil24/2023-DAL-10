package com.example.thymeleaf_tour.TestController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyControllertwo {
    @GetMapping({"login"})
    public String showIndex(){
        return "index";
    }
}
