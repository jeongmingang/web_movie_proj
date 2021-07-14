package web_movie_proj.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_movie_proj.dto.Cinema;
import web_movie_proj.service.CinemaService;


@RestController
@RequestMapping("/api")
public class RestCinemaController {
	
	@Autowired
	private CinemaService service;
	
	@GetMapping("/cinemas")
	public ResponseEntity<Object> cinemas () {
		System.out.println("cinemas()");
		return ResponseEntity.ok(service.getLists());
	}
	
	@GetMapping("/cinemas/{cinNo}")
	public ResponseEntity<Object> cinema (@PathVariable int cinNo, HttpServletResponse response) throws IOException {
		Cinema cinema = service.getCinema(new Cinema(cinNo));
		if (cinema == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(cinema);
	}

}
