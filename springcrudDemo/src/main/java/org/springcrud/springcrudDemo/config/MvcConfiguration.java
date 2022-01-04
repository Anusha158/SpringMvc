package org.springcrud.springcrudDemo.config;

import javax.sql.DataSource;

import org.springcrud.springcrudDemo.Dao.StudentDao;
import org.springcrud.springcrudDemo.Dao.StudentDaoImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="org.springcrud.springcrudDemo")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mysql");
        dataSource.setUsername("admin");
        dataSource.setPassword("Hello@15");
         
        return dataSource;
    }
     
    @Bean
    public StudentDao getStudentDAO() {//method is bean id like in xml 
    	StudentDaoImp daoImp=new StudentDaoImp();
    	daoImp.setJdbcTemplate(getJdbcTemplate()); //setter in jection
    	return daoImp;  
    }
 
    @Bean
    public JdbcTemplate getJdbcTemplate() {//method is bean id like in xml 
        return new JdbcTemplate(getDataSource()); //constructor injection
    }
    
	
}
