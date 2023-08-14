package org.nequiltaborn.imbibinglush.controllers;

import org.nequiltaborn.imbibinglush.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

   @GetMapping("/")
    public String index(){return "index";}

    @GetMapping("/login")
    public String login(){return "login";}

    @GetMapping("/register")
    public String register(){return "registration";}

    @GetMapping("/home")
    public String home(){return "home";}

//       @GetMapping("/liqour")
//    public String liquor(){return "liquor";}
}
