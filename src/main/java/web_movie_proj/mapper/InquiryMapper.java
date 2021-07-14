package web_movie_proj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import web_movie_proj.dto.Inquiry;

@Component
public interface InquiryMapper {

	List<Inquiry> selectInquiryAll();
	List<Inquiry> selectInquiryByUser(String user);
	List<Inquiry> selectInquiryByAnsStatus(int inqStatus);
	Inquiry selectInquiryByNo(int inqNo);
	
	
	int insertInquiry(Inquiry inquiry);
	int updateInquiry(Inquiry inquiry);
	int deleteInquiry(int inqNo);
}
