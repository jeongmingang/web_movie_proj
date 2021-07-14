package web_movie_proj.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import web_movie_proj.dto.Member;
import web_movie_proj.exception.MemberNotFoundException;
import web_movie_proj.service.MemberDetailService;

@Controller
public class MemberDetailController {
	
	@Autowired
	private MemberDetailService memberService;

	@GetMapping("/login/{memEmail}")
	public ModelAndView detail(@PathVariable("memEmail") String memEmail) {
		Member member = memberService.showMemberByMemEmail(memEmail);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/memberDetail");
		return mav;
	}

	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "member/invalidId";
	}

	@ExceptionHandler(MemberNotFoundException.class)
	public String handeMemberNotFoundException() {
		return "member/noMember";
	}
}
