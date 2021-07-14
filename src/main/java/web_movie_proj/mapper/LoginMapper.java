package web_movie_proj.mapper;

import org.springframework.stereotype.Component;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.RegisterRequest;

@Component
public interface LoginMapper {
	//로그인
    public Member LoginCommand(Member member);
    
    RegisterRequest logincheck(String memEmail, String memPasswd);
	public void logincheck(Member member);
}