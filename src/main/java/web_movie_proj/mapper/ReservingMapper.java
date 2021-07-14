package web_movie_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import web_movie_proj.dto.Reserving;

@Component
public interface ReservingMapper {
	// 상영정보번호로 예매진행중인 좌석정보 받아오기
	List<Reserving> selectReservingByShowNo(int no);
	
	// 기본번호로 예매진행중인 정보 찾기
	Reserving selectReservingByIngNo(int no);
	
	int insertReserving(Reserving reserving);
	int deleteReserving(int no);
	
}
