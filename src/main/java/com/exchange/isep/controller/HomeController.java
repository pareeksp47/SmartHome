/**
 * 
 */
package com.exchange.isep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exchange.isep.model.User;

/**
 * @author SAURABH
 *
 */
@Controller
public class HomeController {

	
	@GetMapping({"/"})
    public String register(Model model, HttpServletRequest request) {
		
		String result = "home";
		HttpSession session = request.getSession(false);
		if(null != session && null != session.getAttribute("user")) {
			User user = (User) session.getAttribute("user");
			
			if(user.getUserRole().equalsIgnoreCase("Customer")) {
				
				result = "redirect:/userDashboard";
			}else {
				
				result = "redirect:/adminDashboard";
			}
		}
        return result;
    }
}
