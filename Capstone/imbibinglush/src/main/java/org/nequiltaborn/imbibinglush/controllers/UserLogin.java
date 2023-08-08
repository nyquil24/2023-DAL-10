package org.nequiltaborn.imbibinglush.controllers;

import org.nequiltaborn.imbibinglush.models.User;
import org.nequiltaborn.imbibinglush.services.UserLoginDto;
import org.nequiltaborn.imbibinglush.services.UserRegistrationDto;
import org.nequiltaborn.imbibinglush.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*Handles HTTP Requests */

@Controller
@RequestMapping("/login")
public class UserLogin {

//    private final UserService userService;
//
//    public UserLogin(UserService uSerService){
//        super();
//        this.userService = uSerService;
//    }

//    @ModelAttribute("user")
//    public UserLoginDto userLoginDto(){
//        return new UserLoginDto();
//    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
