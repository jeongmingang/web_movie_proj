package web_movie_proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web_movie_proj.dto.Member;
import web_movie_proj.exception.MemberNotFoundException;
import web_movie_proj.mapper.MemberMapper;

@Service
public class ChangePasswordService {
	
	@Autowired
	private MemberMapper membermapper;

	@Transactional
	public void changePassword(String memEmail, String oldPwd, String newPwd) {
		Member member = membermapper.selectMemberByEmail(memEmail);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		membermapper.updateMember(member);
	}
}