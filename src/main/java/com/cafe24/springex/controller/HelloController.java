package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("email", "Googleok@gmail.com");
		mav.setViewName("/WEB-INF/views/hello.jsp");

		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		model.addAttribute("email", "YoriBoGo@gmail.com");
		return "/WEB-INF/views/hello.jsp";
	}
		
	@RequestMapping("/hello4")
	public String hello4(Model model,
			@RequestParam("email") String email,
			@RequestParam String name /*어노테이션에 value 생략시 변수이름으로 parameter 값을 찾는다.*/) {
		System.out.println(name);
		model.addAttribute("email", email);
		return "/WEB-INF/views/hello.jsp";
	}
	
	// spring에 servlet 기술 침투 했기 떄문에 비추천
	@RequestMapping("/hello5")
	public String hello5(Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name);
		model.addAttribute("email", email);
		return "/WEB-INF/views/hello.jsp";
	}
}




