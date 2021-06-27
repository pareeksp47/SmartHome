/**
 * 
 */
package com.exchange.isep.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exchange.isep.model.Mdjavahash;
import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;

/**
 *
 * This controller is responsible for the user registration.
 */
@Controller
public class RegistrationController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mdjavahash md5;

  Logger logger = LoggerFactory.getLogger(RegistrationController.class);

  /**
   * if a new user wants to register to the website.
   * @param model
   * @return
   */
  @GetMapping({
    "/register"
  })
  public String register(Model model) {
    return "registration";
  }
  /**
   * Save new customer details
   * Save user details 
   * @param request
   * @return
   */
  @RequestMapping(value = "/saveUserDetails", method = RequestMethod.POST)
  public String saveUserRegDetails(HttpServletRequest request) {

    try {
      HttpSession session = request.getSession(false);

      if (null != session && null != session.getAttribute("user")) {

        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        Date createdOn = new Date();
        boolean status = true;
        String userRole = "Customer";

        password = md5.getHashPass(password);

        User user = new User(0, firstName, lastName, email, createdOn, status, userRole, password, gender);
        userRepository.addCustomer(user);

      }

    } catch (Exception e) {
      logger.error("Error occured while saving new customer " + e.getMessage());
    }

    return "login";
  }

  /**
   * Save new admin details
   * @param request
   * @return
   */
  @RequestMapping(value = "/saveAdminDetails", method = RequestMethod.POST)
  public String saveAdminRegDetails(HttpServletRequest request) {

    try {
      HttpSession session = request.getSession(false);

      if (null != session && null != session.getAttribute("user")) {
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date createdOn = new Date();
        boolean status = true;
        String userRole = "Admin";

        User user = new User(0, firstName, lastName, email, createdOn, status, userRole, password, "");
        userRepository.addAdmin(user);
      }
    } catch (Exception e) {
      logger.error("Error occured while saving admin details " + e.getMessage());
    }
    return "users";
  }

}