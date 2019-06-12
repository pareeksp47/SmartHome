/**
 * 
 */
package com.exchange.isep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;


@Controller
public class ForgotPasswordController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping({"/forgotPassword"})
    public String forgotPassword(Model model) {
        return "forgotPassword";
        
    }
	
	@GetMapping({"/forgotPassword_2"})
    public String forgotPassword_2(@RequestParam(value="email") String email,HttpServletRequest request,Model model) {
		System.out.println("Email---------> "+email);
		request.setAttribute("email", email);
        return "forgotPassword_2";
        
    }
	
	@RequestMapping(value="forgotPasswordChange",method=RequestMethod.POST)
	 public String updateUser(@RequestParam(value="email") String email, @RequestParam(value="pswd") String password,
			 HttpServletRequest request){

			String result = "";
		
			try {
			HttpSession session =  request.getSession();
			if(null == session) {
				result = "login";
			}else {
				
				//User user = (User)session.getAttribute("user");
				
					userRepository.updateUser(email, password);;
					result =  "redirect:/login";
				
			}
			
			}catch(Exception e) { 
			result = "error";
			System.out.println("Error :"+e);
			}
			
			return result;
	}
	
}
