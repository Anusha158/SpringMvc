package org.springcrud.springcrudDemo.Model;

public class Student {
	public Student() {
		super();
	}
	private int id;
	public Student(int id, String studentName, String emailId) {
		super();
		this.id = id;
		StudentName = studentName;
		this.emailId = emailId;
	}
	private String StudentName;
	private String emailId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
		
		
	}

