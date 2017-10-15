package com.bigdata2017.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	/* request mapping (method 단독 mapping) */
	/* @ResponseBody가 붙어있으면 view가 아닌 message로 생각함. 없으면 바로 MessageConverter로 보내서 String view message를 보내고,
	 * 객체라면 에러를 리턴함. 따라서 객체를 보내서 JSON형태를 만들어 view단으로 보내고 싶다면 꼭 @ResponseBody를 붙여야함 */
	@ResponseBody
	@RequestMapping("/main")
	public String main() {
		return sendMessage( "main" );
	}
	
	/* 아래와같이  HttpRequest, HttpServletResponse등을 받아 servlet과 똑같이 만들 수는 있으나, 
	 * 저건 톰캣이 처리해주는 녀석이니 Spring에서는 관여하지 않는게 컨셉(기술 비침투)
	 * 따라서 쓸 수는 있으나 컨셉위반이라 지양함 */
	@ResponseBody
	@RequestMapping("/main2/a/b/c")
//	public String main2(
//			HttpRequest request, 
//			HttpServletResponse response,
//			HttpSession session,
//			Writer out) {
	public String main2() {
		return sendMessage( "main2" );
	}
	
	private String sendMessage( String message ) {
		return "MainController:" + message;
	}
}
