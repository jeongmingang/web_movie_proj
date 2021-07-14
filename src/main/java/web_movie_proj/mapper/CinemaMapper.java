package web_movie_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import web_movie_proj.dto.Cinema;

@Component
public interface CinemaMapper {
	List<Cinema> selectCinemaByAll();
	Cinema selectCinemaByNo(Cinema cinema);
}
