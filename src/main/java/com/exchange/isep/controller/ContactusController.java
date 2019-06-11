package com.exchange.isep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ContactusController {
	
	@GetMapping({"/contactus"})
    public String contact(Model model) {
        return "contactus";
        
    }
	
	@PostMapping({"/contactus"})
    public String createcontactus(Model model) {
        return "contactus";
        
    }
	

}
