package web_movie_proj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Member;
import web_movie_proj.dto.Reservation;

@Service
public interface ReservationService {

	List<Reservation> getLists();
	List<Reservation> getReservationByUser(Member member);
	
	int registReservation(Reservation reservation);
	int removeReservation(Reservation reservation);
	
	Reservation getReservationInfoByNo(int no);
	
	List<Reservation> getReservationListByMemNo(int no);
}
