package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.demo.dao.DeveloperDao;
import com.telusko.demo.dao.JpaDemo;
import com.telusko.demo.model.Developer;

@RestController
public class DevController {
	@Autowired
	DeveloperDao developerDao;

	@Autowired
	JpaDemo jpaDemo;

	@RequestMapping("/")
	public String home() {

		return "Form.jsp";

	}

	@RequestMapping("/addDev")
	public String addDeveloper(Developer developer) {

		developerDao.save(developer);
		return "Form.jsp";

	}
	/*
	 * @RequestMapping("/getbyId") public ModelAndView getbyId(@RequestParam int
	 * DevId) { ModelAndView mv=new ModelAndView(); Developer
	 * developer=developerDao.findById(DevId).orElse(new Developer()); //
	 * System.out.println(developer); //
	 * System.out.print(developerDao.findBySkill("java")); //
	 * System.out.print(developerDao.findByDevIdGreaterThan(1));
	 * System.out.println(developerDao.findByToolSorted("eclipse"));
	 * mv.addObject(developer); mv.setViewName("view.jsp"); return mv;
	 * 
	 * }
	 * 
	 */

	@GetMapping("/developers")
	public List<Developer> getDevelopers() {
		return jpaDemo.findAll();
	}

	@GetMapping("/developer/{devId}")
	public Optional<Developer> getDevelopers(@PathVariable("devId") int devId) {
		return jpaDemo.findById(devId);
	}

	@PostMapping(path="/developeradd")
	public Developer addDev(@RequestBody Developer developer) {
		System.out.println("inside add");
		 jpaDemo.save(developer);
		 return developer;
	}

	@DeleteMapping("/remove/{devId}")
	public Developer removeDevelopers(@PathVariable("devId") int devId) {
		 Developer devp=jpaDemo.getById(devId);
		 System.out.println(devp);
		  jpaDemo.delete(devp);
		  return devp;
	}
	@PutMapping(path="/developerUpdate")
	public Developer updateDev(@RequestBody Developer developer) {
		
		 jpaDemo.save(developer);
		 return developer;
	}
}
