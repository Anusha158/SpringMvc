package org.springcrud.springcrudDemo.Dao;

import java.util.List;

import org.springcrud.springcrudDemo.Model.CommunicationDTO;
import org.springcrud.springcrudDemo.Model.Student;

public interface StudentDao {

	public int saveOrUpdate(Student student);

	public List<Student> ViewAll();

	public List<Student> findStudentById(int studentId);

	public int updateById(Student student);

	public int delete(int studentId);

	}
