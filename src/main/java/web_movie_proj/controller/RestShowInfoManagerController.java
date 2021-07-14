package web_movie_proj.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_movie_proj.dto.Cinema;
import web_movie_proj.dto.Movie;
import web_movie_proj.dto.ShowInfo;
import web_movie_proj.dto.Theater;
import web_movie_proj.service.ShowInfoService;

@RestController
@RequestMapping("/api")
public class RestShowInfoManagerController {
	
	@Autowired
	private ShowInfoService service;
	
	@GetMapping("/showinfo")
	public ResponseEntity<Object> showInfoList(){
		System.out.println("showInfoList()");
		return ResponseEntity.ok(service.getLists());
	}
	
	@GetMapping("/showinfo/{no}")
	public ResponseEntity<Object> showinfo(@PathVariable int no, HttpServletResponse response) {
		ShowInfo showInfo = service.getShowInfo(new ShowInfo(no));
		if (showInfo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(showInfo);
	}
	
	@PostMapping("/showinfo")
	public ResponseEntity<Object> newShowInfo(@RequestBody ShowInfo showInfo) {
		System.out.println("newShowInfo > " + showInfo);
		
		service.registShowInfo(showInfo);
		URI uri = URI.create("/api/showinfo/" + showInfo.getShwNo());

		return ResponseEntity.created(uri).body(showInfo.getShwNo());
	}
	
	@PatchMapping("/showinfo/{no}")
	public ResponseEntity<Object> updateShowInfo(@PathVariable int no, @RequestBody ShowInfo showInfo) {
		return ResponseEntity.ok(service.modifyShowInfo(showInfo));
	}
	
	@DeleteMapping("/showinfo/{no}")
	public ResponseEntity<Object> deleteShowInfo(@PathVariable int no) {
		return ResponseEntity.ok(service.removeShowInfo(new ShowInfo(no)));
	}
	
	@GetMapping("/showinfobycondition/{movNo}/{thtNo}/{shwDate}")
	public ResponseEntity<Object> showInfoListByCondition(@PathVariable int movNo, @PathVariable int thtNo, @PathVariable String shwDate){
		System.out.println("showInfoListByCondition()");
		
		ShowInfo showInfo = new ShowInfo();
		showInfo.setMovNo(new Movie(movNo));
		showInfo.setThtNo(new Theater(thtNo));
		
		LocalDate shwLocalDate = LocalDate.parse(shwDate, DateTimeFormatter.ISO_DATE);
		showInfo.setShwDate(shwLocalDate);
		
		return ResponseEntity.ok(service.getListsByCondition(showInfo));
	}
	
	// 극장별 상영정보
	@GetMapping("/showInfoListByTheater/{thtNo}/{shwDate}")
	public ResponseEntity<Object> showInfoListByTheater(@PathVariable int thtNo, @PathVariable String shwDate){
		System.out.println("showInfoListByTheater()");
		
		ShowInfo showInfo = new ShowInfo();
		showInfo.setThtNo(new Theater(thtNo));
		
		LocalDate shwLocalDate = LocalDate.parse(shwDate, DateTimeFormatter.ISO_DATE);
		showInfo.setShwDate(shwLocalDate);
		
		return ResponseEntity.ok(service.getShowInfoListByTheater(showInfo));
	}
	
	// 극장, 상영관, 날짜로 상영정보에 등록되어 있는 시간 조회
	@GetMapping("/timelistbycondition/{thtNo}/{cinNo}/{shwDate}")
	public ResponseEntity<Object> timeListByCondition(@PathVariable int thtNo, @PathVariable int cinNo, @PathVariable String shwDate){
		System.out.println("timeListByCondition()");
		
		ShowInfo showInfo = new ShowInfo();
		showInfo.setThtNo(new Theater(thtNo));
		showInfo.setCinNo(new Cinema(cinNo));
		
		LocalDate shwLocalDate = LocalDate.parse(shwDate, DateTimeFormatter.ISO_DATE);
		showInfo.setShwDate(shwLocalDate);
		
		return ResponseEntity.ok(service.getTimeListByCondition(showInfo));
	}
}
