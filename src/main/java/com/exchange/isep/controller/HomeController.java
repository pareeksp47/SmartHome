/**
 * 
 */
package com.exchange.isep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.exchange.isep.model.User;

/**
 * @author SAURABH
 *
 */
@Controller
public class HomeController {

	
	/**
	 * 
	 * @param http request
	 * @return home page name for different users
	 */
	@GetMapping({"/"})
    public String register(HttpServletRequest request) {
		
		String result = "home";
		// get current session of this request
		HttpSession session = request.getSession(false);
		
		// check if session/ user obj is empty or not
		if(null != session && null != session.getAttribute("user")) {
			
			// get user from session
			User user = (User) session.getAttribute("user");
			
			// user role is customer,  redirect user to user dashboard 
			if(user.getUserRole().equalsIgnoreCase("Customer")) {
				
				result = "redirect:/userDashboard";
				// user role is customer,  redirect user to admin dashboard 
			}else {
				result = "redirect:/adminDashboard";
			}
		}
        return result;
    }
}
