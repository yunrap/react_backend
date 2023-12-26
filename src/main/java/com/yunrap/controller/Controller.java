package com.yunrap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {

	@RequestMapping(value = "/")
	public ModelAndView sample(HttpServletRequest https) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("sample page controller log");
		mv.setViewName("sample");
		
		return mv;
	}

	/**
	 * 데이터조회
	 * @param request
	 * @return
	 */
	@RequestMapping("/json/getDataList.json")
	@ResponseBody
	public void getDataList(HttpServletRequest request) {
		System.out.println("데이터타는가");

	}

	/**
	 * 프론트엔드 연결테스트
	 * @param
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "백엔드에서 프론트엔드로 값을 전달합니다!";
	}
}
