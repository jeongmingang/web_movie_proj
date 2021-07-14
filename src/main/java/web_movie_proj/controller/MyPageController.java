package web_movie_proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage/mypage";
	}
	
	@RequestMapping("/reserveInfo")
	public String reserveInfo() {
		return "mypage/reservelist";
	}
	
	@RequestMapping("/commentInfo")
	public String commentInfo() {
		return "mypage/comment";
	}
	
	@RequestMapping("/inquiryInfo")
	public String inquiryInfo() {
		return "mypage/inquiry";
	}
	
}
