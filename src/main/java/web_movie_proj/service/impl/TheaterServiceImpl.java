package web_movie_proj.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_movie_proj.dto.Theater;
import web_movie_proj.mapper.TheaterMapper;
import web_movie_proj.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {
	static final Log log = LogFactory.getLog(TheaterServiceImpl.class);

	@Autowired
	private TheaterMapper mapper;

	@Override
	public List<Theater> getLists() {
		List<Theater> list = mapper.selectTheaterByAll();
		log.debug("service - getLists() > " + list.size());
		return list;
	}

	@Override
	public Theater getTheater(int thtNo) {
		log.debug("service - getTheater() > " + thtNo);
		return mapper.selectTheaterByNo(thtNo);
	}

	@Override
	public Theater getTheaterName(String thtName) {
		log.debug("service - getTheaterName() > " + thtName);
		return mapper.selectTheaterByName(thtName);
	}	
}
