package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Statistics;
import web_movie_proj.dto.StatisticsCommand;

@Service
public interface StatisticsService {
	int showTotalSales();
	
	List<Statistics> showSalesByLatestDate();
	List<Statistics> showSalesByMonth();
	
	List<StatisticsCommand> showAudienceByMovie();
}
