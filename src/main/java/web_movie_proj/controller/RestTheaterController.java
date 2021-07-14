package web_movie_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_movie_proj.dto.Theater;
import web_movie_proj.service.TheaterService;


@RestController
@RequestMapping("/api")
public class RestTheaterController {
	
	@Autowired
	private TheaterService service;
	
	@GetMapping("/theaters")
	public ResponseEntity<Object> theaters () {
//		System.out.println("theaters()");
		return ResponseEntity.ok(service.getLists());
	}
	
	@GetMapping("/theaters/{thtNo}")
	public ResponseEntity<Object> theater (@PathVariable int thtNo) {
		Theater theater = service.getTheater(thtNo);
		return ResponseEntity.status(HttpStatus.OK).body(theater);
	}

}
