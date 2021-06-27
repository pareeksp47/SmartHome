/**
 * 
 */
package com.exchange.isep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exchange.isep.model.Mdjavahash;
import com.exchange.isep.model.User;
import com.exchange.isep.repository.UserRepository;

/**
 * @author SAURABH
 * This controller is responsible for managing the user login.
 *
 */
@Controller
public class LoginController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mdjavahash mdHash;
  
  Logger logger = LoggerFactory.getLogger(LoginController.class);

  @GetMapping({
    "/login"
  })
  public String register(Model model) {
    return "login";
  }

  /**
   * Used for authenticating the user.
   * @param http request 
   * @return
   */
  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  @ResponseBody
  public String authenticateUser(HttpServletRequest request) {

    String result = "login";
    try {
      String userName = request.getParameter("username");
      String password = request.getParameter("password");
      String encryptedPassword = mdHash.getHashPass(password);

      User user = userRepository.authenticate(userName, encryptedPassword);
      if (null != user) {
        // based on user profile redirect the user to specific landing page after login
        if (null != user.getUserRole() && user.getUserRole().equalsIgnoreCase("Customer")) {
          result = "userDashboard";
        } else {
          result = "adminDashboard";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
      } else {

        result = "login?error=error";
      }
    } catch (Exception e) {
      logger.error("Error occured during authentication :" + e);
      result = "error";
    }
    return result;
  }

  /**
   * Used for removing the current user from the session.
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request, HttpServletResponse response) {

    String result = "redirect:/login";
    try {
      HttpSession session = request.getSession(false);
      if (null != session) {
        if (null != session.getAttribute("User")) {
          session.setAttribute("User", null);
        }
        session.invalidate();

      }
    } catch (Exception e) {
      logger.error("Error occured while trying to logout :" + e);
      result = "error";
    }
    return result;
  }
}