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
	
	@GetMapping({ "/adminDashboard" })
	public String register(Model model) {
		return "adminDashboard";
	}
	

	@RequestMapping(value="/adminData", method = RequestMethod.GET)
	@ResponseBody
	public String adminDashboardData(@RequestParam(value = "id") String id,
			HttpServletRequest request) {

		String result = "";
		try {

			HttpSession session = request.getSession(false);
//			if(null != session) {

				User user = (User) session.getAttribute("user");
				if(null != user) {
					
					List<User> userList = userRepository.findAll();
									
					ObjectMapper mapper = new ObjectMapper();
					UserListDetails userListDetails = new UserListDetails();
					userListDetails.userList = userList;
					result = mapper.writeValueAsString(userList);
					
				}else {
					result = "error";
				}
//			}
//			else {
//				result = "login";
//			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
			result = "error";
		}

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
}
