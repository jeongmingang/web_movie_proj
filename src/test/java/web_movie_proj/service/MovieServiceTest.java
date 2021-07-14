package web_movie_proj.service;

import java.time.LocalDate;
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
import web_movie_proj.dto.Movie;
import web_movie_proj.mapper.MovieMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovieServiceTest {

	protected static final Log log = LogFactory.getLog(MovieServiceTest.class);
	
	@Autowired
	private MovieMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01GetLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Movie> list = mapper.selectMovieAll();
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test02GetMovie() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Movie selMovie = new Movie(1);
		Movie movie = mapper.selectMovieByNo(selMovie);
		Assert.assertNotNull(movie);
		
		log.debug(movie.toString());
	}
	
	@Test
	public void test03GetMovieBoxOffice() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Movie selMovie = new Movie(14);		// 상영예정작인 15번 영화는 안보임
		Movie movie = mapper.selectMovieByBoxofficeNo(selMovie);
		Assert.assertNotNull(movie);
		
		log.debug(movie.toString());
	}
	
	@Test
	public void test04GetMovieBoxOfficeLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Movie> list = mapper.selectMovieBoxOfficeAll();
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	public void test05GetMovieCommingSoonLists() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Movie> list = mapper.selectMovieCommingSoonAll();
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	public void test06GetMovieByTitle() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Movie> list = mapper.selectMovieByTitle("크루");
		Assert.assertNotNull(list);
		
		list.forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test07RegisterMovie() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		LocalDate start = LocalDate.of(2021, 06, 07);
		LocalDate end = LocalDate.of(2021, 06, 10);
		Movie newMovie = new Movie("test movie", 12, "액션", 120, "감독", "배우들", "상세설명", start, end, 3.5, "poster.jpg", "null");
		
		int res = mapper.insertMovie(newMovie);
		Assert.assertEquals(1, res);
		log.debug("res no >> " + res);
		
		mapper.deleteMovie(newMovie);	
	}

	@Test
	public void test08ModifyMovie() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		LocalDate start = LocalDate.of(2021, 06, 17);
		LocalDate end = LocalDate.of(2021, 06, 20);
		
		Movie newMovie = new Movie("test movie", 12, "액션", 120, "감독", "배우들", "상세설명", start, end, 3.5, "poster.jpg", "null");
		mapper.insertMovie(newMovie);
		
		newMovie.setMovTitle("test movie2");
		newMovie.setMovGrade(15);
		newMovie.setMovGenre("액션2");
		newMovie.setMovRuntime(220);
		newMovie.setMovDirector("감독2");
		newMovie.setMovActor("배우들2");
		newMovie.setMovDetail("상세설명2");
		newMovie.setMovOpendate(LocalDate.of(2021, 07, 17));
		newMovie.setMovEnddate(LocalDate.of(2021, 07, 20));
		newMovie.setMovAvgstar(4.5);
		newMovie.setMovPoster("poster2.jpg");
		
		int res = mapper.updateMovie(newMovie);
		Assert.assertEquals(1, res);
		
		mapper.deleteMovie(newMovie);
	}

	@Test
	public void test09RemoveMovie() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		LocalDate start = LocalDate.of(2021, 06, 17);
		LocalDate end = LocalDate.of(2021, 06, 20);
		
		Movie newMovie = new Movie("test movie", 12, "액션", 120, "감독", "배우들", "상세설명", start, end, 3.5, "poster.jpg", "null");
		mapper.insertMovie(newMovie);
		int res = mapper.deleteMovie(newMovie);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test10modifyMovieAvgStar() {		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Movie movie = new Movie();
		movie.setMovNo(1);
		
		int res = mapper.updateMovieAvgStar(movie);
		Assert.assertEquals(1, res);
		log.debug("res no >> " + res);
	}

}
