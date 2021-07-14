package web_movie_proj.service;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.RegisterRequest;

@Service
public interface LoginService {
	//로그인
    public Member LoginCommand(Member member);
    
    RegisterRequest logincheck(String memEmail, String memPasswd);
}