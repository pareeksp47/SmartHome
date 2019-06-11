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
	public String allUsers(HttpServletRequest request) {

		String result = "";
		
		
		try {

	    	HttpSession reqSession = request.getSession(false);
	    
	    	if(null == reqSession || null == reqSession.getAttribute("user")){
	    		
	    		result = "login";
	    	}else {
	    		List<User> users = userRepository.findAll();

				ObjectMapper mapper = new ObjectMapper();
				result = mapper.writeValueAsString(users);
	    		
	    	}
		}catch(Exception e) {
			result = "error";
		}
 
		return result;
	}



}
