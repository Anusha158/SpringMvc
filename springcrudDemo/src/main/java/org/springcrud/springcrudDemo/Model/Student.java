package org.springcrud.springcrudDemo.Model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springcrud.springcrudDemo.Validator.AgeValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	public Student() {
		super();
	}
	@NotNull
	
	private int id;
	
	@NotBlank(message=" * Name cannot be blank")
	@Size(min = 3,max=15,message="* Name should be 3-15 characters")
	private String studentName;
	
	@AgeValidator(lower=30,upper=60,message="Age should be between 18-60")
	private Integer age;
	
	@Autowired
	@Valid
	private CommunicationDTO communicationDTO;
	
	public Student(int id, String studentName,CommunicationDTO communicationDTO) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.communicationDTO=communicationDTO;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", emailId=" + communicationDTO.getEmailId() + ", Phone=" + communicationDTO.getPhone().getNumber()+communicationDTO.getPhone().getCountryCode() + "]";
	}

	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}

	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
		
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
		
		
	}

