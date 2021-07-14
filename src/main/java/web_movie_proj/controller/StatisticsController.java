package web_movie_proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
	
	@GetMapping("/salesManager")
	public String salesManaging() {
		return "manager/salesManaging";
	}
	
}
