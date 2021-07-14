package web_movie_proj.service;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;

@Service
public interface MemberDetailService {
	Member showMemberByMemEmail(String memEmail);
}
