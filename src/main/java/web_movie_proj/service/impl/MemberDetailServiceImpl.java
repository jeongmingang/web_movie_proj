package web_movie_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;
import web_movie_proj.mapper.MemberMapper;
import web_movie_proj.service.MemberDetailService;

@Service
public class MemberDetailServiceImpl implements MemberDetailService {
	
	@Autowired
	private MemberMapper membMapper;
	
	@Override
	public Member showMemberByMemEmail(String memEmail) {
		return membMapper.selectMemberByEmail(memEmail);
	}
}
