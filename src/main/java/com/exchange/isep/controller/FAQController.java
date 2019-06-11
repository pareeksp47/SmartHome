package com.exchange.isep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exchange.isep.model.FAQ;
import com.exchange.isep.repository.FAQRepository;

/**
 * 
 * @author Neethu
 *
 */
@Controller
public class FAQController {
	
	@Autowired
	FAQRepository faqRepository;
	
	@GetMapping({"/getFAQ"})
    public String forgotPassword(Model model) {
		java.util.List<FAQ> faqList = faqRepository.getFAQ();
		model.addAttribute("lists", faqList);
        return "faq";
    }
    
	

}
