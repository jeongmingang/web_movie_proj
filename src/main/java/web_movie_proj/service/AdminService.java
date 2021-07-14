package web_movie_proj.service;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.Admin;

@Service
public interface AdminService {
	Admin getAdmin(Admin admin);
}
