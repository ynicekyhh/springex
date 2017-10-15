package com.bigdata2017.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/board" )
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/write")
	public String write(
			/* @RequestParam( "no" ) Long no */ 
			/* 위 방식에서는 사용자가 no 파라미터를 넣지 않으면 Http에서 400에러를 리턴하는데, 아래와 같이 기본값을 세팅해 놓아 사용자가 보기 불편하지 않게 함 */
			@RequestParam( value="no", required=true, defaultValue="0") Long no,
			@RequestParam( value="name", required=true, defaultValue="") String name
			) {
		
		System.out.println( no );
		System.out.println(name);
		return "BoardController:write";
	}
	
	@ResponseBody
	@RequestMapping("/view/{no}")
	public String view(	@PathVariable( value="no" ) Long no	) {
		
		System.out.println( "no:" + no );
		return "BoardController:view";
	}
}
