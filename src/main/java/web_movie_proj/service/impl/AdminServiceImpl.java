package web_movie_proj.service.impl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_movie_proj.dto.Admin;
import web_movie_proj.mapper.AdminMapper;
import web_movie_proj.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	static final Log log = LogFactory.getLog(AdminServiceImpl.class);
	
	@Autowired
	private AdminMapper admapper;

	@Override
	public Admin getAdmin(Admin admin) {
		log.debug("service - getAdmin() > " + admin);
		return admapper.getAdmin(admin);
	}
}
