package com.example.thymeleaf_tour.mycontroller;


import com.example.thymeleaf_tour.model.UserTwo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ModelAndVeiwcontroller {

    @GetMapping("/showViewPage")
    public String passParamterWIthModel(Model model){
        model.addAttribute("message", "Perschool");
        model.addAttribute("welcomeMessage", "welcome");
        int i = 10;
        model.addAttribute("number", i);

        List<String> list = Arrays.asList("one", "two");
        model.addAttribute("listData", list);
        return "viewPage";
    }

    @GetMapping("/goToViewPage")
    public ModelAndView passParameterWithModelAndView(){
        String st = "Welcome to the Page";
        ModelAndView modelAndView = new ModelAndView("viewPage_2");
        modelAndView.addObject("message", st);
        modelAndView.addObject("info", "Employee information");
        return modelAndView; 
    }

    @GetMapping("/goToUserViewPage")
    public ModelAndView UserModelAndView(){
        List<UserTwo> listUsers = new ArrayList<UserTwo>();
        listUsers.add(new UserTwo(1, "Haseeb", "haseeb@abc.com,"));
        listUsers.add(new UserTwo(2, "Shahparan", "Shahparan@abc.com,"));
        listUsers.add(new UserTwo(3,"James", "James@abc.com,"));
        listUsers.add(new UserTwo(4, "Joseph", "Joseph@abc.com,"));

        ModelAndView modelAndView = new ModelAndView("userdata");
        modelAndView.addObject("userlist", listUsers);
        return modelAndView;

    }
}
