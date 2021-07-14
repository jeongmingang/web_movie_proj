package web_movie_proj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_movie_proj.dto.Statistics;
import web_movie_proj.dto.StatisticsCommand;
import web_movie_proj.mapper.StatisticsMapper;
import web_movie_proj.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsMapper mapper;
	
	@Override
	public int showTotalSales() {	
		return mapper.selectTotalSales();
	}

	@Override
	public List<Statistics> showSalesByLatestDate() {
		return mapper.selectSalesByLatestDate();
	}

	@Override
	public List<Statistics> showSalesByMonth() {
		return mapper.selectSalesByMonth();
	}

	@Override
	public List<StatisticsCommand> showAudienceByMovie() {
		
		return mapper.selectAudienceByMovie();
	}

}
