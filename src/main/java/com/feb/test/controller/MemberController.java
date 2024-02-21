package com.feb.test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.test.service.MemberService;

@Controller
public class MemberController {

	@Autowired // MemberService의 자동 의존성 주입
	private MemberService memberService;

	@PostMapping("/join.do") // HTTP POST 요청을 /join.do로 매핑하기 위한 애너테이션입니다.
	public ModelAndView join(@RequestParam HashMap<String, String> params) { // params라는 이름의 HashMap<String, String> 타입의
																				// 매개변수를 받는다.
		System.out.println("params : " + params);
		
		String memberName = params.get("firstName") + " " + params.get("lastName");
		System.out.println("memberName : " + memberName);
		params.put("memberName", memberName);
		
		// 이 매개변수는 회원가입 정보를 담고 있는 파라미터들을 받아온다.
		// @RequestParam 애너테이션은 HTTP 요청 파라미터를 메서드의 매개변수에 바인딩하는데 사용
		ModelAndView mv = new ModelAndView(); // 새로운 ModelAndView 객체를 생성(ModelAndView는 컨트롤러가 처리한 결과를 담고 있는 객체)
		int result = memberService.join(params); // memberservice의 join 메서드를 호출하여 params라는 이름의 매개변수를 들고와서 회원등록을 시도
		System.out.println("result22222222222222222222222222222 : " + result); // result값 찍는방법

		System.out.println(123123123);
		// int result는 memberService.join(params) 메서드의 반환값을 저장하기 위한 변수


		mv.setViewName("login"); // 메서드가 처리한 결과를 보여줄 뷰의 이름을 나타냄(즉, 회원가입 성공하든 실패하든 로그인 페이지로 이동하게 설정한 것.)

		// 회원 등록 결과에 따른 메시지 추가
//        성공 시: 1
//        실패 시: 0 또는 음수

		if (result == 1) {
			mv.addObject("resultMsg", "회원가입 성공");// addObject()메서드 --> 키-값 쌍을 추가하여 해당 데이터를 ModelAndView로 전달
		} else
			mv.addObject("resultMsg", "회원가입 실패");// 회원 등록이 실패

		return mv;
	}

}
