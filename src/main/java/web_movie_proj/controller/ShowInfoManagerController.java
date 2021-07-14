package web_movie_proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web_movie_proj.service.CinemaService;
import web_movie_proj.service.MovieService;
import web_movie_proj.service.TheaterService;

@Controller
public class ShowInfoManagerController {
	
	@Autowired
	private MovieService movService;
	
	@Autowired
	private TheaterService thtService;
	
	@Autowired
	private CinemaService cinService;
	
	@RequestMapping("/showInfoManager")
	public String showInfoList() {
		return "manager/showInfoManager/showInfoList";
	}
	
	@RequestMapping("/registShowInfo")
	public String registShowInfo(Model model) {
		model.addAttribute("getMovieList", movService.getMovieListFromToday());
		model.addAttribute("getTheaterList", thtService.getLists());
		model.addAttribute("getCinemaList", cinService.getLists());
		return "manager/showInfoManager/registShowInfo";
	}
}
