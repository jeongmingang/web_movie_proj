package web_movie_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import web_movie_proj.dto.Theater;

@Component
public interface TheaterMapper {
	List<Theater> selectTheaterByAll();
	Theater selectTheaterByNo(int thtNo);
	Theater selectTheaterByName(String thtName);
}
