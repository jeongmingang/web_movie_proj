package web_movie_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.RegisterRequest;
import web_movie_proj.mapper.LoginMapper;
import web_movie_proj.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginMapper logmapper;

	@Override
	public Member LoginCommand(Member member) {
		return logmapper.LoginCommand(member);
	}

	@Override
	public RegisterRequest logincheck(String memEmail, String memPasswd) {
		return logmapper.logincheck(memEmail, memPasswd);
	}
}