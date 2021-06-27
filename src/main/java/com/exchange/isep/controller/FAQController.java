package com.exchange.isep.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exchange.isep.model.FAQ;
import com.exchange.isep.repository.FAQRepository;

/**
 * 
 * @author Neethu
 * This controller is responsible for getting the Frequently Asked Questions (FAQ) and their answers.
 */
@Controller
public class FAQController {

  @Autowired
  FAQRepository faqRepository;

  Logger logger = LoggerFactory.getLogger(LoginController.class);

  /**
   * Fetch FAQ details
   * @param model
   * @return
   */
  @GetMapping({
    "/getFAQ"
  })
  public String forgotPassword(Model model) {
    try {
      java.util.List < FAQ > faqList = faqRepository.getFAQ();
      model.addAttribute("lists", faqList);

      return "faq";
    } catch (Exception e) {
      logger.error("Error occured while fetching faq details " + e.getMessage());
    }
    return "faq?error=true";
  }

}