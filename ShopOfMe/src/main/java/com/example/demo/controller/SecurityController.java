package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message","Login");
		return "security/login";
	}

	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message","SUCCESS");
		return "redirect:/product/list";
	}
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","FAILL");
		return "security/login";
	}

	@RequestMapping("/security/login/unauthoried")
	public String loginUnauthoried(Model model) {
		model.addAttribute("message","loginUnauthoried");
		return "security/login";
	}

	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message","logoff");
		return "security/login";
	}
}








