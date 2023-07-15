package com.example.thymeleaf_tour.TestController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class MyController {
    @RequestMapping({"/login"})
    public String showlogin(){
        return "inboxpage";
    }
    @RequestMapping("/")
    public String simplemethod(){
        return "inboxpage";
    }

    @RequestMapping("/index")
    public String showindex() {
        return "inboxpage";

    }


}
