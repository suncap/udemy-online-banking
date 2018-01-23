package com.userfront.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userfront.domain.User;
import com.userfront.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UserService userService;

	@RequestMapping("/primaryAccount")
	public String primaryAccount(Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("primaryAccount", user.getPrimaryAccount());
		return "primaryAccount";
	}

	@RequestMapping("/savingsAccount")
	public String savingsAccount(Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("savingsAccount", user.getSavingsAccount());
		return "savingsAccount";
	}
}
