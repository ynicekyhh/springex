package com.bigdata2017.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/guestbook/*" )
public class GuestbookController {
	
	/* 아래와같이 @RequestMapping에 경로를 안붙이면 method이름과 동일한 경로를 지정함, 허나 명시적으로 지정하는게 좋음 */
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping
	public String insert() {
		return "GuestbookController:insert";
	}
}
