/**
 * 
 */
package com.exchange.isep.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.exchange.isep.model.Mdjavahash;
import com.exchange.isep.repository.UserRepository;

/**
 * This controller is responsible for managing the forgot password option of the login.
 */
@Controller
public class ForgotPasswordController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mdjavahash mdHash;
  
  Logger logger = LoggerFactory.getLogger(ForgotPasswordController.class);

  @GetMapping({
    "/forgotPassword"
  })
  public String forgotPassword(Model model) {
    return "forgotPassword";

  }

  @GetMapping({
    "/forgotPassword_2"
  })
  public String forgotPassword_2(@RequestParam(value = "email") String email, HttpServletRequest request, Model model) {

    request.setAttribute("email", email);
    return "forgotPassword_2";

  }

  @RequestMapping(value = "forgotPasswordChange", method = RequestMethod.POST)
  public String updateUser(@RequestParam(value = "email") String email, @RequestParam(value = "pswd") String password,
    HttpServletRequest request) {

    String result = "";

    try {
      HttpSession session = request.getSession();
      if (null == session) {
        result = "login";
      } else {

        String encryptedPassword = mdHash.getHashPass(password);
        userRepository.updateUser(email, encryptedPassword);
        result = "redirect:/login";

      }

    } catch (Exception e) {
      result = "error";
      logger.error("Error occured while updating the forgot password :" + e);
    }

    return result;
  }

}