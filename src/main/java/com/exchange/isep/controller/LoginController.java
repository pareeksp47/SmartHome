/**
 * 
 */
package com.exchange.isep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;

/**
 * @author SAURABH
 *
 */
@Controller
public class LoginController {
	
	 @Autowired
	    private UserRepository userRepository;

	@GetMapping({"/login"})
    public String register(Model model) {
        return "login";
    }
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	@ResponseBody
	public String authUser(HttpServletRequest request) {
		
		String result = "login";
		try {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
		
			
			User user = userRepository.authenticate(userName, password);
			if(null != user) {
				if(null != user.getUserRole() && user.getUserRole().equalsIgnoreCase("Customer")) {
					result = "userDashboard";
				}else {
					result = "adminDashboard";
				}
				
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
			}else {
				
				
				result = "login?error=error";
			}
		} catch (Exception e) {
			System.out.println("Error :"+e);
			result= "error";
		}
		return result;
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		String result = "redirect:/login";
		try {
			 HttpSession session =  request.getSession(false);
			 if(null != session) {
				 if(null != session.getAttribute("User")) {
					 session.setAttribute("User", null);
				 }
				 session.invalidate();
				 
			 }
		} catch (Exception e) {
			System.out.println("Error :"+e);
			result= "error";
		}
		return result;
	}
}
