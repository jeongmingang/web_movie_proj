package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Movie;

@Service
public interface MovieService {
	List<Movie> getLists();
	Movie getMovie(Movie movie);
	// 박스오피스 번호
	Movie getMovieBoxOffice(Movie movie);
	// 박스 오피스
	List<Movie> getMovieBoxOfficeLists();
	// 상영예정작
	List<Movie> getMovieCommingSoonLists();
	
	// 영화 제목으로 검색
	List<Movie> getMovieByTitle(String movTitle); 
	
	int registerMovie(Movie movie);
	int modifyMovie(Movie movie);
	int removeMovie(Movie movie);
	
	// 영화 실시간 평점 업뎃
	int modifyMovieAvgStar(Movie movie);
	
	// 상영종료일이 오늘이후인 영화 목록
	List<Movie> getMovieListFromToday();
	// 상영중인 최신 영화 중 평점 상위 영화 3개 리스트
	List<Movie> getMovieLimit();
}
