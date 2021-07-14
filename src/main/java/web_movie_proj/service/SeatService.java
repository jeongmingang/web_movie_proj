package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Seat;

@Service
public interface SeatService {
	List<Seat> getListByShowInfoNo(int showNo);
	
	int registSeat(Seat seat);
	int removeSeat(int no);
	
	List<Seat> getListByResNo(int no);
	
}
