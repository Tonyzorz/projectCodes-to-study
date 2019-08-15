 
 package com.bit.pet.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.pet.model.dto.UserBean;
import com.bit.pet.model.service.AdoptionBoardService;
import com.bit.pet.model.service.JournalBoardService;
import com.bit.pet.model.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	JournalBoardService journalBoardService;
	@Autowired
	AdoptionBoardService adoptionBoardService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("jallList", journalBoardService.jMainBoard());
		model.addAttribute("aallList", adoptionBoardService.aMainBoard());
		return "mainPage";
	}
	
	
	@RequestMapping("login")
	public String goLogin() {
		return "user/login";
	}
	
	@RequestMapping("signup")
	public String goSignup() {
		return "user/signup";
	}
	
	@RequestMapping("loginCheck")
	public String loginCheck(UserBean userBean, HttpSession session) {
		session.setAttribute("userId",userBean.getUserId());
		String nextPage = userService.loginCheck(userBean)? "redirect:/":"redirect:login";
		return nextPage;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "signupCheck", method=RequestMethod.POST)
	public String signupCheck(UserBean userBean, BindingResult bindingResult) {
		userService.signupCheck(userBean, bindingResult);
		if(bindingResult.hasErrors()) {
			return "signup";
		}
		return "redirect:/";
	}
}