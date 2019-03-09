package org.dxh.spring.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/hello")
	public ModelAndView getListaUtentiView(HttpServletRequest request
											,HttpServletResponse response){
		String abc = request.getParameter("a");
		System.out.println(abc);
	    ModelMap model = new ModelMap();
	    model.addAttribute("name", "Spring Boot JSP!");
	    return new ModelAndView("index", model);
	}
}
