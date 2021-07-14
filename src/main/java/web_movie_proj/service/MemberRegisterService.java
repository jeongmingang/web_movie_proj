package web_movie_proj.service;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.RegisterRequest;

@Service
public interface MemberRegisterService {
	String regist(String memEmail, RegisterRequest req);

	Member select(String memEmail);
}
