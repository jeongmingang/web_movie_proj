package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.RegisterRequest;

@Service
public interface RestMemberService {
	List<Member> showMembers();
	Member showMemberById(Long memId);
	Long regist(RegisterRequest req);

}
