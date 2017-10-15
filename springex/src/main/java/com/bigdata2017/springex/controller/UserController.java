package com.bigdata2017.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/* request mapping( type + method ) */

@Controller
@RequestMapping("/user")
public class UserController {

//	1번방식
//	@RequestMapping("/joinform")
//	public String joinform() {
//		return "/WEB-INF/views/join.jsp";
//	}
	
	/* 2번, overloading */
	@RequestMapping( value="/join", method=RequestMethod.GET )
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	/* 여러 url을 줄 때는 아래와 같은 방식으로 */
//	@RequestMapping( {"/join", "/doJoin"} )
//	1번방식
	/* 2번 방식으로 String을 넘겨주니까 ResponseBody는 Message를 넘겨주지 않게 되니 제대로 처리가 안됨. 따라서 @ResponseBody를 빼줌 */
//	@ResponseBody
	@RequestMapping( value="/join", method=RequestMethod.POST )
	public String join(
			/*
			 * 아래의 방식에서 @ModelAttribute를 쓰는방식으로 변경(vo를 가져와 parameter와 이름이 같은 값을 vo.set으로 자동매칭시켜준다.) 
			 * 데이터가 많을 때 더욱 유용함 => 따라서 이름을 함부로 쓰면 안됨
			@RequestParam("name") String name,
			@RequestParam("email") String email
			*/
			@ModelAttribute UserVo userVo
			) {
		
//		UserVo vo = new UserVo();
//		vo.setName(name);
//		vo.setEmail(email);
		System.out.println(userVo);
//		1번 방식으로 redirect
//		return "UserController:join";
		
		/* redirect를 붙이기만 해도 redirect가 된다. */
		return "redirect:/main";
	}
	
	@ResponseBody
	@RequestMapping( value="/loginform", method=RequestMethod.GET )
	public String loginform() {
		return "UserController:loginform";
	}
	
	@ResponseBody
	@RequestMapping( value="/login", method=RequestMethod.POST )
	public String login() {
		return "UserController:login";
	}
}
