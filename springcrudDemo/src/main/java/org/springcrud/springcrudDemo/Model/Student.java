package org.springcrud.springcrudDemo.Model;

public class Student {
	public Student() {
		super();
	}
	private int id;
	public Student(int id, String studentName, String emailId) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.emailId = emailId;
	}
	private String studentName;
	private String emailId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
		
		
	}

