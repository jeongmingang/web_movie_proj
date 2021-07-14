package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.ShowInfo;

@Service
public interface ShowInfoService {
	List<ShowInfo> getLists();
	ShowInfo getShowInfo(ShowInfo showInfo);
	int registShowInfo(ShowInfo showInfo);
	int modifyShowInfo(ShowInfo showInfo);
	int removeShowInfo(ShowInfo showInfo);
	
	List<ShowInfo> getListsByCondition(ShowInfo showInfo);
	List<ShowInfo> getShowInfoListByTheater(ShowInfo showInfo);
	
	List<ShowInfo> getTimeListByCondition(ShowInfo showInfo);
}
