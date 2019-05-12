/**
 * 
 */
package com.exchange.isep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author MANJUSREE
 *
 */
@Controller
public class UserDashboardController {
	
    @GetMapping({"/userDashboard"})
    public String userDB(Model model) {
        return "userDashboard";
    }

}
