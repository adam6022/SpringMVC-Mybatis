package com.zgadam.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	/**
	 * Ìø×ªµ½µÇÂ½Ò³Ãæ
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String username,String password,
			HttpSession session) {
		System.out.println(username);
		System.out.println(password);
		
		session.setAttribute("username", username);
		
		return "redirect:/item/itemList.action";
	}
}
