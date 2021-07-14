package web_movie_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_movie_proj.dto.AuthInfo;
import web_movie_proj.dto.Member;
import web_movie_proj.exception.WrongIdPasswordException;
import web_movie_proj.mapper.MemberMapper;
import web_movie_proj.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private MemberMapper memMapper;
	
	@Override
	public AuthInfo authenicate(String memEmail, String memPasswd) {
		Member member = new Member();
		member.setMemEmail(memEmail);
		member.setMemPasswd(memPasswd);
		
		Member mem = memMapper.selectMemberByEmail(memEmail);
		
		if (mem == null) {
			throw new WrongIdPasswordException();
		}
		
		if (!member.matchPassword(memPasswd)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getMemEmail(), member.getMemName(), member.getMemPasswd(), member.getMemBirthdate(), member.getMemPhone());
	}	
}
