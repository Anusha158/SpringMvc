package org.springcrud.springcrudDemo.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springcrud.springcrudDemo.Dao.StudentDao;
import org.springcrud.springcrudDemo.Model.CommunicationDTO;
import org.springcrud.springcrudDemo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
	
	@RequestMapping("/") /* before loading home page Student fields are getting binded */
    public String showform(@ModelAttribute("student") Student student){    
      
        return "Login";   
    }    
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("student") Student student,BindingResult result ,ModelAndView mv
			) {
		System.out.println("inside create");
		if(result.hasErrors()) {
			
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError temp:allErrors) {
				System.out.println(temp);
			}
			
			mv.setViewName("Login");
			return mv;
		}
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
	//	List<CommunicationDTO> cdto=studentDao.ViewAll();
		
		List<Student> list=studentDao.ViewAll();
for(Student s:list) {
			System.out.println("display each"+s.getCommunicationDTO().getEmailId());
		}
		System.out.println(list);
		model.addObject("list", list);
		model.setViewName("viewAll");
		return model;
	}
	
	@RequestMapping(value = { "/update/{studentId}","/verify/{studentId}"})
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("studentId") int studentId,HttpServletRequest req)
			throws IOException {
		System.out.println(req.getRequestURI());
		String requestURI = req.getRequestURI();
		List<Student> listStudent = studentDao.findStudentById(studentId);
		System.out.println("in update"+listStudent);
		
		if(requestURI.contains("verify")) {
			System.out.println("inside verify");
			model.addObject("list", listStudent);
			model.setViewName("viewAll");
		}	else {	
			model.addObject("listStudent", listStudent);
		model.setViewName("update");
		}
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
