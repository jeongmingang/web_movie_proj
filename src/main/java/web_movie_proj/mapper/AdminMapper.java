package web_movie_proj.mapper;

import org.springframework.stereotype.Component;

import web_movie_proj.dto.Admin;

@Component
public interface AdminMapper {
	public Admin getAdmin(Admin admin);
}
