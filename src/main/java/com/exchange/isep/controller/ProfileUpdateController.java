package com.exchange.isep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This controller is responsible for updating the user profile. 
 */
@Controller
public class ProfileUpdateController {

  @GetMapping({
    "/updateProfile"
  })
  public String profile(Model model) {
    return "updateProfile";

  }

  @PostMapping({
    "/updateProfile"
  })
  public String createProfile(Model model) {
    return "updateProfile";

  }

}