package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Cinema;

@Service
public interface CinemaService {
	List<Cinema> getLists();
	Cinema getCinema(Cinema cinema);
}
