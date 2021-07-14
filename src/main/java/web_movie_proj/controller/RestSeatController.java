package web_movie_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_movie_proj.service.SeatService;

@RestController
@RequestMapping("/api")
public class RestSeatController {
	
	@Autowired
	private SeatService service;
	
	@GetMapping("/seat/{no}")
	public ResponseEntity<Object> seatList(@PathVariable int no){
		return ResponseEntity.ok(service.getListByShowInfoNo(no));
	}
	
	@GetMapping("/seatbyresno/{no}")
	public ResponseEntity<Object> seatListByResNo(@PathVariable int no){
		return ResponseEntity.ok(service.getListByResNo(no));
	}

}
