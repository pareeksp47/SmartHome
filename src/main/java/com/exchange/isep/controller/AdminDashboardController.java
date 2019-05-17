package com.exchange.isep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {

	@GetMapping({ "/adminDashboard" })
	public String register(Model model) {
		return "adminDashboard";

	}
	
	@GetMapping({ "/createAdmin" })
	public String createAdmin(Model model) {
		return "createAdmin";

	}
	
	@GetMapping({ "/adminProfileEdit" })
	public String adminProfileEdit(Model model) {
		return "adminProfileEdit";

	}
	@GetMapping({ "/random" })
	public String random(Model model) {
		return "random";

	}
}
