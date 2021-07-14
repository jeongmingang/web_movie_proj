package web_movie_proj.service;

import org.springframework.stereotype.Service;

import web_movie_proj.dto.AuthInfo;

@Service
public interface AuthService {
	public AuthInfo authenicate(String memEmail, String memName);
}
