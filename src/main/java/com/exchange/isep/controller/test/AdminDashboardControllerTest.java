/**
 * 
 */
package com.exchange.isep.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.exchange.isep.builder.ReqBuilder;
import com.exchange.isep.controller.AdminDashboardController;
import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;

/**
 * @author Pareek
 *
 */
@SpringBootTest
@WebMvcTest(AdminDashboardController.class)

public class AdminDashboardControllerTest {

	@Autowired
	  private MockMvc mockMvc;
	
	 @Autowired
	  private UserRepository userRepository;
	 
	 @Autowired
	  private ReqBuilder reqBuilder;
	

     @Autowired
     private WebApplicationContext wac;

     protected MockHttpSession session;

     protected MockHttpServletRequest request;

     @BeforeEach
     public void setup() {
         this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
     }
	 
	@Test
	public void deleteUserTest() throws Exception{
		
		 Mockito.doNothing().when(userRepository).deleteUser(123);
		 MvcResult result = this.mockMvc.perform(reqBuilder.get("/users")).andReturn();
		 createSession(result);
		 assertEquals(result.getResponse().getContentAsString().contains("adminDashboard"), "User deleted successfully");
		 
	}
	
	@Test
	public void adminDashboardTest() throws Exception{
		
		Mockito.when(userRepository.findAll()).thenReturn(UserControllerTest.getUsers());
		 MvcResult result = this.mockMvc.perform(reqBuilder.get("/users")).andReturn();
		 assertEquals(result.getResponse().getContentAsString().contains("adminDashboard"), "Admin dashboard access allowed");
		 
	}
	
	@Test
	public void editUserTest() throws Exception{
		
		 Mockito.doNothing().when(userRepository).updateUser("abc@gmail.com","123");
		 MvcResult result = this.mockMvc.perform(reqBuilder.get("/users")).andReturn();
		 assertEquals(result.getResponse().getContentAsString().contains("adminDashboard"), "User updated successfully");
		 
	}
	
	
	public void createSession(MvcResult result) {
		HttpSession session = result.getRequest().getSession();
		 session.setAttribute("user", createUser());
		 
	}
	
	public User createUser() {
		return  new User(0, "Jermie", "Surblime", "jermie@gmail.com", new Date(), true, "Customer", "rfdfidfud", "male");
	}
	
}
