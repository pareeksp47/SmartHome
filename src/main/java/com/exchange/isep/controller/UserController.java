/**
 * 
 */
package com.exchange.isep.controller;

import java.util.List;

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

	@RequestMapping(value="/users", method = RequestMethod.GET) 
	public String allUsers() {
		
		String result = "";
		try {
			List<User> users = userRepository.findAll();
			
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(users);
		} catch (Exception e) {
			System.out.println("Error :"+e);
		}
		return result;
	}

}
