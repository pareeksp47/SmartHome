package com.exchange.isep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.exchange.isep.model.ApartmentDao;

@Controller
public class ProfileController {
	
	@GetMapping({"/profile"})
    public String profile(Model model) {
        return "profile";
        
    }
	
	@PostMapping({"/profile"})
    public String createProfile(Model model) {
        return "profile";
        
    }
	
}
