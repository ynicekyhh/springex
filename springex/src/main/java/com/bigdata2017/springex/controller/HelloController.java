package com.bigdata2017.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView hello(
			@RequestParam( value="n", required=true, defaultValue="" ) String name
			) {
		/* 내가 받은 param을 JSP로 넘기고 싶을 때
		 * ModelAndView를 쓰면 객체를 forwarding하고 싶을 때 */
		ModelAndView mav = new ModelAndView();
		/* jsp에서 ${name} 이렇게 받을 수 있게 세팅함 */
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	/* 내가 ModelAndView를 직접 new하지 않고, DispatcherServlet에서 관리하는 Model에 값을 넣어서 사용하게함
	 * 이 방식으로 String을 넘겨주면 url이 되고, 객체를 넘겨주면 JSON방식으로 넘겨주게 하게됨, new로 생성할 필요 없음 */
	@RequestMapping("/hello2")
	public String hello2(
			@RequestParam( value="n", required=true, defaultValue="" ) String name, Model model
			) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello.jsp";
	}
}
