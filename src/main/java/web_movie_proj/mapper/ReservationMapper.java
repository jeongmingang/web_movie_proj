package web_movie_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.Reservation;

@Component
public interface ReservationMapper {

	List<Reservation> selectReservationAll();
	List<Reservation> selectReservationByUser(Member member);
	
	int insertReservation(Reservation reservation);
	int deleteReservation(Reservation reservation);
	
	// 예매번호로 정보 가져오기
	Reservation selectReservationByNo(int no);
	
	// 회원번호로 예매내역 가져오기
	List<Reservation> selectReservationByMemNo(int no);
}
