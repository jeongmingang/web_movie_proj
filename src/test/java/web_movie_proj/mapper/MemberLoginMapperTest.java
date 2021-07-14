package web_movie_proj.mapper;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import web_movie_proj.config.ContextRoot;
import web_movie_proj.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberLoginMapperTest {
	
	@Autowired
	private MemberMapper memMapper;

	@Test
    public void memberLogin() throws Exception{
        
        Member member = new Member(); 
        
        // 올바른 아이디 비번 입력경우
        member.setMemEmail("test1@test.com");
        member.setMemPasswd("1234");
        
        // 틀린 비번 입력경우
//        member.setMemEmail("test13@test.com");
//        member.setMemPasswd("12345");
        
        memMapper.memberLogin(member);
        System.out.println("결과 값 : " + memMapper.memberLogin(member));    
    }
}
