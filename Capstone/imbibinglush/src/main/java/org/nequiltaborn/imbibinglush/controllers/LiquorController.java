package org.nequiltaborn.imbibinglush.controllers;

import org.nequiltaborn.imbibinglush.models.Liquor;
import org.nequiltaborn.imbibinglush.services.LiquorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LiquorController {


    @Autowired
    private LiquorService liquorService;


    // supposed to display list of Liquors
    @GetMapping("/liquor")
    public String viewHomePage(Model model){
        model.addAttribute("listLiquors", liquorService.getAllLiquors());
        return "liquor";
    }

    @GetMapping("/showNewLiquorForm")
    public String showNewLiquorForm(Model model){
        //Create a model attribute to bind form data
        Liquor liquor = new Liquor();
        model.addAttribute("liquor",liquor);
        return "new_liquor";
    }

    @PostMapping("/saveLiquor")
    public String saveLiquor(@ModelAttribute("liquor") Liquor liquor){
        //save liquor to database
        liquorService.saveLiquor(liquor);
        return "redirect:/liquor";

    }

    @GetMapping("/showFormForLUpdate/{id}")
    public String showFormForLUpdate(@PathVariable(value="id") long id, Model model ){

        // get employee form the service
        Liquor liquor = liquorService.getLiquorById(id);

        //set employuee as a model attribute to populate the form
        model.addAttribute("liquor", liquor);
        return "update_liquor";
    }

    @GetMapping("/deleteLiquor/{id}")
    public String deleteLiquor(@PathVariable (value = "id") long id){
        // call delete employee method
        this.liquorService.deleteEmployeeById(id);
        return "redirect:/liquor";
    }

}
