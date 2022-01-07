package org.springcrud.springcrudDemo.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springcrud.springcrudDemo.Dao.StudentDao;
import org.springcrud.springcrudDemo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
;

@Controller
public class HomeController {
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/")    
    public String showform(@ModelAttribute("student") Student student){    
      
        return "Login";   
    }    
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("student") Student student ,ModelAndView mv) {
		System.out.println("inside");
		
		int counter=studentDao.saveOrUpdate(student);
		if(counter>0) {
			mv.addObject("msg", student.getStudentName()+" registration successful.");
			mv.addObject("action","create");
		}else
			mv.addObject("msg", "Student registration failed.");
		mv.setViewName("success");
		return mv;
	}
	@RequestMapping(value="/viewAll")
	public ModelAndView ViewAll(ModelAndView model) {
		System.out.println("inside ViewAll");
		
		List<Student> list=studentDao.ViewAll();
		model.addObject("list", list);
		model.setViewName("viewAll");
		return model;
	}
	
	@RequestMapping(value = "/update/{studentId}")
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("studentId") int studentId)
			throws IOException {

		List<Student> listStudent = studentDao.findStudentById(studentId);
		model.addObject("listStudent", listStudent);
		model.setViewName("update");

		return model;
	}
	
	@RequestMapping(value = "/update/updatebyid")
	public ModelAndView updateById(@ModelAttribute("student") Student student,ModelAndView mv)
			throws IOException {
		System.out.println("inside update");
		
		int counter=  studentDao.updateById(student);
		if(counter>0) {
			mv.addObject("msg", "Updated successfully.");
		}else
			mv.addObject("msg", "Updation failed.");
		mv.setViewName("success");//ctrl+shift+r
		return mv;
		

		
	}
	@RequestMapping(value = "/delete/{studentId}")
	public ModelAndView delete(@PathVariable("studentId") int studentId)
			throws IOException {
		
		System.out.println("inside delete");
	int count= studentDao.delete(studentId);
	ModelAndView mv =new ModelAndView();
		if(count>0) {

			mv.addObject("msg", studentId+" deleted");
			/*
			 * mv.addObject("action",delete); mv.addObject("studentId", studentId);
			 */
		}else
			mv.addObject("msg", " row not deleted");
		mv.setViewName("success");
		return mv;
	}
}
