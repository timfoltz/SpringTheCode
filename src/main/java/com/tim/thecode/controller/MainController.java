package com.tim.thecode.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
//		session.setAttribute("guess", null);
		System.out.println(session.getAttribute("guess"));
		return "index.jsp";
	}
	
	@RequestMapping(path = "/submit", method = RequestMethod.POST)
	public String submitCode(@RequestParam String code, HttpSession session) {
		session.setAttribute("guess", code);
		System.out.println(code);
		
		if(code.equals("bushido")){
			return "redirect:/code";
		}
		else {
			session.setAttribute("guess", null);
			return "redirect:/createError";
		}
	}
	
	@RequestMapping("/code")
	public String code(HttpSession session, Model model) {
		if(session.getAttribute("guess")!=null) {
			return "code.jsp";
		}
		else {return "redirect:/createError";}
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("code", null);
		return "redirect:/";
	}
	
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes	) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
}
