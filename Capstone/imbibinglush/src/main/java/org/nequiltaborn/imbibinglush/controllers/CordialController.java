package org.nequiltaborn.imbibinglush.controllers;

import org.nequiltaborn.imbibinglush.models.Cordial;
import org.nequiltaborn.imbibinglush.services.CordialService;
import org.nequiltaborn.imbibinglush.services.CordialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CordialController {

    @Autowired
    private CordialService cordialService;

    @GetMapping("/cordial")
    public String showCordialList(Model model){
       //List<Cordial> listCordials = service.listAllCordials();
       model.addAttribute("listCordial", cordialService.getAllCordials());

       return "cordial";
    }

}
