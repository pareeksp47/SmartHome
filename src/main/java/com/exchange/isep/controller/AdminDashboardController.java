package com.exchange.isep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exchange.isep.model.Apartment;
import com.exchange.isep.model.DashboardDetails;
import com.exchange.isep.model.Room;
import com.exchange.isep.model.Sensor;
import com.exchange.isep.model.User;
import com.exchange.isep.model.UserListDetails;
import com.exchange.isep.repository.UserDashboardRepository;
import com.exchange.isep.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Pareek
 * Admin dashboard is used for handling/managing the different user access to the application
 *  
 */
@Controller
public class AdminDashboardController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ObjectMapper mapper;
	/**
	 * @api -  adminDashboard
	 * 
	 * @param http request
	 * @return if a valid request returns all the list of users available/accessing this application.
	 */
	@RequestMapping({ "/adminDashboard" })
	public String adminDashboard(HttpServletRequest request) {

		// final result formation
		String result = "";
		try {

			// return the current session for this request
			HttpSession session = request.getSession(false);
			
			// if session is null, means user needs to login
			if(null == session) {
				result = "login";
				
			}else {
				// if session is present get user details from session
				User user = (User) session.getAttribute("user");
			
				// validate user obj, if null return to login.
				if(null == user) {
					result = "login";
				}else {
					// get all user from repository.
					List<User> userList = userRepository.findAll();
							
					
					UserListDetails userListDetails = new UserListDetails();
					userListDetails.users = userList;
		
					// add the users to the session
					session.setAttribute("userList", userList);
					
					// result set to admin dashborad
					result = "adminDashboard";
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error occured while accessing Admin dashboard "+e);
			result = "error";
		}
		System.out.println("Admin controller dashboard access response : "+ result);
		return result;
	}


	@GetMapping({ "/createAdmin" })
	public String createAdmin(Model model) {
		return "createAdmin";

	}
	
	@GetMapping({ "/adminProfileEdit" })
	public String adminProfileEdit(Model model) {
		return "adminProfileEdit";

	}
	@GetMapping({ "/random" })
	public String random(Model model) {
		return "random";

	}
	
	/**
	 * 
	 * @param id
	 * @param http request
	 * @return
	 */
	@RequestMapping(value="deleteUser",method=RequestMethod.GET)
	 public String deleteUser(@RequestParam(value="id") int id,
			 HttpServletRequest request){

			String result = "";
			
			try {
				// return the current session for this request
			HttpSession session =  request.getSession(false);
			
			// if session is null, means user needs to login
			if(null == session) {
				result = "login";
			}else {
				
				User user = (User)session.getAttribute("user");
				
				// validate user obj, if null return to login.
				if(null == user) {
					result = "login";
				}else{
					
					userRepository.deleteUser(id);
					result =  "redirect:/adminDashboard";
				}
			}
			
			}catch(Exception e) {
			result = "error";
			System.out.println("Error :"+e);
			}
			
			return result;
 }
	@RequestMapping(value="editAdminProfile",method=RequestMethod.POST)
	 public String updateUser(@RequestParam(value="email") String email, @RequestParam(value="pswd") String password,
			 HttpServletRequest request){

			String result = "";
		
			try {
			HttpSession session =  request.getSession(false);
			if(null == session) {
				result = "login";
			}else {
				User user = (User)session.getAttribute("user");
				if(null == user) {
					result = "login";
				}else {
					userRepository.updateUser(email, password);;
					result =  "redirect:/adminDashboard";
				}
			}
			
			}catch(Exception e) { 
			result = "error";
			System.out.println("Error :"+e);
			}
			
			return result;
	}
}
