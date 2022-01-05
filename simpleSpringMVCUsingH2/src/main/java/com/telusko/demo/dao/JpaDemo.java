package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.demo.model.Developer;

public interface JpaDemo extends JpaRepository<Developer,Integer>{

}
