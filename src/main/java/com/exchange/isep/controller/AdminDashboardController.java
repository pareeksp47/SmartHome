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

@Controller
public class AdminDashboardController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping({ "/adminDashboard" })
	public String adminDashboard(HttpServletRequest request) {

		String result = "";
		try {

			HttpSession session = request.getSession(false);
			if(null != session) {

				User user = (User) session.getAttribute("user");
			
			//User user = new User(0, result, result, result, null, false, result, result);
				if(null != user) {
					
					List<User> userList = userRepository.findAll();
									
					ObjectMapper mapper = new ObjectMapper();
					UserListDetails userListDetails = new UserListDetails();
					userListDetails.userList = userList;
					result = mapper.writeValueAsString(userList);
					session.setAttribute("userList", userList);
					result = "adminDashboard";
					
				}else {
					result = "error";
				}
			}
			else {
				result = "login";
			}
			
		} catch (Exception e) {
			System.out.println("Error ____________________-  "+result);
			e.printStackTrace();
			result = "error";
		}

		return result;
	}


//	@RequestMapping(value="/saveAdminDetails", method = RequestMethod.GET)
//	@ResponseBody
//	public String adminDashboardData(@RequestParam(value = "id") String id,
//			HttpServletRequest request) {
//
//		String result = "";
//		try {
//
//			HttpSession session = request.getSession(false);
////			if(null != session) {
//
//				User user = (User) session.getAttribute("user");
//				if(null != user) {
//					
//					List<User> userList = userRepository.findAll();
//									
//					ObjectMapper mapper = new ObjectMapper();
//					UserListDetails userListDetails = new UserListDetails();
//					userListDetails.userList = userList;
//					result = mapper.writeValueAsString(userList);
//					
//				}else {
//					result = "error";
//				}
////			}
////			else {
////				result = "login";
////			}
//			
//		} catch (Exception e) {
//			System.out.println("Error : " + e);
//			result = "error";
//		}
//
//		return result;
//	}
//	
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
	
	@RequestMapping(value="deleteUser",method=RequestMethod.GET)
	 public String deleteUser(@RequestParam(value="id") int id,
			 HttpServletRequest request){

			String result = "";
			
			try {
			HttpSession session =  request.getSession();
			if(null == session) {
				result = "login";
			}else {
				User user = (User)session.getAttribute("user");
				if(null == user) {
					result = "login";
				}else {
					
					
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
	//updating admin's password
	@RequestMapping(value="editAdminProfile",method=RequestMethod.POST)
	 public String updateUser(@RequestParam(value="email") String email, @RequestParam(value="pswd") String password,
			 HttpServletRequest request){

			String result = "";
		
			try {
			HttpSession session =  request.getSession();
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
