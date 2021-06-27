package com.exchange.isep.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.exchange.isep.builder.ReqBuilder;
import com.exchange.isep.controller.UserController;
import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;

/**
 * @author Pareek
 * User Controller Test cases
 */

@SpringBootTest
@WebMvcTest(UserController.class)
@DataJpaTest
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepository userRepository;

  @Autowired
  private ReqBuilder reqBuilder;

  /**
   * Test case for get all users
   * @throws Exception
   */
  @Test
  public void getAllUserReturn() throws Exception {

    Mockito.when(userRepository.findAll()).thenReturn(getUsers());

    MvcResult result = this.mockMvc.perform(reqBuilder.get("/users")).andReturn();
    assertEquals(result.getResponse().getContentAsString().contains("user"), "Get user records found successfully");
  }

  /**
   * build users
   * @return the list of users
   */
  public static List < User > getUsers() {

    List < User > users = new ArrayList < User > ();
    User user = new User(0, "Jermie", "Surblime", "jermie@gmail.com", new Date(), true, "Customer", "rfdfidfud", "male");
    users.add(user);
    return users;
  }
}