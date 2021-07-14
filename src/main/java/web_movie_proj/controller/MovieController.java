package web_movie_proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
	
	@GetMapping("/movielist")
	public ModelAndView movieList(@RequestParam(defaultValue = "") String movTitle) {
		ModelAndView mav = new ModelAndView("movie/boxOffice", "movTitle", movTitle);
		return mav;
	}
	
	@GetMapping("/searchMovieList")
	public ModelAndView searchMovieList(@RequestParam(defaultValue = "") String movTitle) {
		ModelAndView mav = new ModelAndView("movie/searchMovie", "movTitle", movTitle);
		return mav;
	}
	
	@GetMapping("/movie")
	public ModelAndView movie(@RequestParam(value = "movNo") int movNo) {
		ModelAndView mav = new ModelAndView("movie/movieDetail", "movNo", movNo);
		return mav;
	}
}
