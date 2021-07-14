package web_movie_proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieManagerController {

	@RequestMapping("/movieManager")
	public String movieList() {
		return "manager/movieManager/movieList";
	}
	
	@RequestMapping("/registMovie")
	public String registMovie() {
		return "manager/movieManager/registMovie";
	}
	
	@RequestMapping("/updateMovie")
	public String updateMovie() {
		return "manager/movieManager/updateMovie";
	}
	
}
