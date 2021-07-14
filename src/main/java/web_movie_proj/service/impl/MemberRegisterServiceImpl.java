package web_movie_proj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.RegisterRequest;
import web_movie_proj.exception.DuplicateMemberException;
import web_movie_proj.mapper.MemberMapper;
import web_movie_proj.service.MemberRegisterService;

@Service
public class MemberRegisterServiceImpl implements MemberRegisterService {
	
	@Autowired
	private MemberMapper memberMapper;

	public Member select(String memEmail) {
		Member member = memberMapper.selectMemberByEmail(memEmail);
		return member;
	}

	@Override
	public String regist(String memEmail, RegisterRequest req) {
		Member member = memberMapper.selectMemberByEmail(req.getMemEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email" + req.getMemEmail());
		}
		
		Member newMember = new Member(req.getMemEmail(), req.getMemPasswd(), req.getMemBirthdate(), req.getMemName(), req.getMemPhone());
		memberMapper.insertMember(newMember);
		
		return newMember.getMemEmail();
	}

}
