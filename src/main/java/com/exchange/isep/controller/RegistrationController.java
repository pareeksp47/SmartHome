/**
 * 
 */
package com.exchange.isep.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;

/**
 * @author SAURABH
 *
 */
@Controller
public class RegistrationController {
	@Autowired
	private UserRepository userRepository;
	
		
	
    @GetMapping({"/register"})
    public String register(Model model) {
        return "registration";
    }
    
    @RequestMapping(value = "/saveUserDetails", method = RequestMethod.POST)
    public String saveUserRegDetails(HttpServletRequest  request) {
    	String firstName = request.getParameter("fname");
    	String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        Date createdOn = new Date();
        boolean status = true;
        String userRole =  "Customer";
    	User user = new User(0, firstName, lastName, email, createdOn, status, userRole, password,gender);
    	userRepository.addCustomer(user);
    	
    	//HttpSession session = request.getSession(true);
		//session.setAttribute("user", user);
        return "redirect:/login";
    }
    
    @RequestMapping(value = "/saveAdminDetails", method = RequestMethod.POST)
    public String saveAdminRegDetails(HttpServletRequest  request) {
    	String firstName = request.getParameter("fname");
    	String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date createdOn = new Date();
        boolean status = true;
        String userRole =  "Admin";
    	///need to change---> 
        User user = new User(0, firstName, lastName, email, createdOn, status, userRole, password,"");
    	userRepository.addAdmin(user);
        return "adminDashboard";
    }
    

}
