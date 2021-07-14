package web_movie_proj.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import web_movie_proj.config.ContextRoot;
import web_movie_proj.dto.Comment;
import web_movie_proj.dto.Movie;
import web_movie_proj.mapper.CommentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommentServiceTest {

	protected static final Log log = LogFactory.getLog(CommentServiceTest.class);
	
	@Autowired
	private CommentMapper mapper;
	
	@Autowired
	private CommentService service;
	
	static int no = 0;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01GetLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Comment> list = mapper.selectCommentAll();
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test02GetCommentByUser() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Comment> list = mapper.selectCommentByUser("test1@test.com");
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}
	
	// 영화 상세 페이지 한줄평 관련 test 추가
	@Test
	public void test03GetCommentByMovNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Comment> list = mapper.selectCommentByMovNo(new Movie(1));
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	public void test04getCommentByComNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Comment comment = mapper.selectCommentByComNo(2);
		
		Assert.assertNotNull(comment);
		log.debug(comment.toString());
	}
	
	@Test
	public void test05GetCommentAvgStar() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Comment> list = mapper.selectCommentAvgStar(new Movie(3));
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	public void test06GetCommentBoxOfficeAvgStarLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Comment> list = mapper.selectCommentBoxOfficeAvgStarAll();
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test07RegistComment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Comment comment = new Comment();
		comment.setMovNo(new Movie(1));
		comment.setComUser("테스트유저");
		comment.setComContent("테스트");
		comment.setComStar(3);
		
		int res = mapper.insertComment(comment);
		Assert.assertEquals(1, res);
		log.debug("res no >> " + res);
		
		no = comment.getComNo();
		System.out.println(no);
	}

	@Test
	public void test08ModifyComment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Comment comment = new Comment(no);
		comment.setComContent("테스트2");
		comment.setComStar(4);
		
		int res = mapper.updateComment(comment);
		Assert.assertEquals(1, res);
		log.debug("res no >> " + res);
	}

	@Test
	public void test09RemoveComment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Comment comment = new Comment(no);
		
		int res = mapper.deleteComment(comment);
		Assert.assertEquals(1, res);
		log.debug("res no >> " + res);
	}
	
	// 트랜젝션 테스트
	//@Test
	public void test10TrRegistComment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Comment comment = new Comment();
		comment.setMovNo(new Movie(4));
		comment.setComUser("테스트유저");
		comment.setComContent("테스트");
		comment.setComStar(5);
		
		service.trRegistComment(comment);
	}
	
	//@Test
	public void test11TrModifyComment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Comment comment = new Comment(270);
		comment.setComContent("테스트2");
		comment.setComStar(3);
		
		service.trModifyComment(comment);
	}
	
	//@Test
	public void test12TrRemoveComment() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Comment comment = new Comment(270);
		
		service.trRemoveComment(comment);
	}

}
