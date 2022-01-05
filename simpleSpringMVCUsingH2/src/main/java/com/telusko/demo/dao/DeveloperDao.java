package com.telusko.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.model.Developer;

public interface DeveloperDao extends CrudRepository<Developer,Integer>{

	List<Developer> findBySkill(String skill);

	

	List<Developer> findByDevIdGreaterThan(int devId); 
	
	@Query("from Developer where tool=?1 order by devId")//JPQL for jpa
	List<Developer> findByToolSorted(String tool);

}
