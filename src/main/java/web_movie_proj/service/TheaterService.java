package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Theater;

@Service
public interface TheaterService {
	List<Theater> getLists();
	Theater getTheater(int thtNo);
	Theater getTheaterName(String thtName);
}
