package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.ReserveCommand;
import web_movie_proj.dto.Reserving;

@Service
public interface ReservingService {
	List<Reserving> getListByShowNo(int no);
	Reserving getReservingByIngNo(int no);
	int registReserving(Reserving reserving);
	int removeReserving(int no);
	
	// 트랜잭션 -> 예매 insert, 좌석 insert, 예매진행중(임시테이블) delete
	int trReserving(ReserveCommand command);
}
