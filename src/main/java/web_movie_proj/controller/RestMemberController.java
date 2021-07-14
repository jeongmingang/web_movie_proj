package web_movie_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_movie_proj.dto.Member;
import web_movie_proj.service.MemberService;

@RestController
@RequestMapping("/api")
public class RestMemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/selectMember/{memEmail}/{memPasswd}")
	public ResponseEntity<Object> timeListByCondition(@PathVariable String memEmail, @PathVariable String memPasswd) throws Exception{
		
		Member member = new Member();
		member.setMemEmail(memEmail);
		member.setMemPasswd(memPasswd);
		
		return ResponseEntity.ok(service.memberLogin(member));
	}
}
