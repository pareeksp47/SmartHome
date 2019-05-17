/**
 * 
 */
package com.exchange.isep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPasswordController {
	
	
    @GetMapping({"/forgotPassword"})
    public String forgotPassword(Model model) {
        return "forgotPassword";
    }
    
	
    @GetMapping({"/forgotPassword_2"})
    public String forgotPassword_2(Model model) {
        return "forgotPassword_2";
    }

}
