package web_movie_proj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class, MvcConfig.class})
@ComponentScan(basePackages = {
		 "web_movie_proj.mapper",  "web_movie_proj.controller"
		 , "web_movie_proj.service", "web_movie_proj.common"  })
public class ContextRoot {

}
