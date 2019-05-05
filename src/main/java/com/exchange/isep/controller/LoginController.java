/**
 * 
 */
package com.exchange.isep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author SAURABH
 *
 */
@Controller
public class LoginController {

	@GetMapping({"/login"})
    public String register(Model model) {
        return "login";
    }
}
