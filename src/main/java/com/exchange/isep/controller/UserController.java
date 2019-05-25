/**
 * 
 */
package com.exchange.isep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SAURABH
 *
 */
@RestController
public class UserController {

	@Autowired
	DataSource dataSource;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String allUsers() {

		String result = "";
		try {
			List<User> users = userRepository.findAll();

			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(users);
		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		return result;
	}
//
//
//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public String authUser(HttpServletRequest request) {
//
//		String result = "login";
//		try {
//			String userName = request.getParameter("username");
//			String password = request.getParameter("password");
//
//			User user = userRepository.authenticate(userName, password);
//			if (null != user) {
//				if (user.getUserRole().equals("Customer")) {
//					result = "userDashboard";
//				} else {
//					result = "adminDashboard";
//				}
//
//				HttpSession session = request.getSession(true);
//				session.setAttribute("user", user);
//			}
//		} catch (Exception e) {
//			System.out.println("Error :" + e);
//			result = "error";
//		}
//		return result;
//	}


}
