package org.springcrud.springcrudDemo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springcrud.springcrudDemo.Model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImp implements StudentDao{
	 private JdbcTemplate jdbcTemplate;

		/*
		 * public StudentDaoImp(DataSource dataSource) { jdbcTemplate = new
		 * JdbcTemplate(dataSource); }
		 */
	 
	 public StudentDaoImp() {
		 
	 }
		
		/*
		 * public StudentDaoImp(JdbcTemplate jdbcTemplate) {
		 * this.jdbcTemplate=jdbcTemplate; } //constructor injection
		 * 
		 */

		 
	    public int saveOrUpdate(Student student) {
	       System.out.println("inside daoimp");
	  
	       try {
	       String sql="insert into Student values(?,?,?)";
	      int  counter=jdbcTemplate.update(sql, new Object[]
	 			  {student.getId(),student.getStudentName(),student.getEmailId()});
	        return counter;
	       }
	       catch(Exception e) {
	    	   System.out.println("insert failed");
	       }			 
	      
			return 0;

	    }

		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		@Override
		public List<Student> ViewAll() {
			 System.out.println("inside view all daoimp");
			String sql="select * from Student ";
			return 	jdbcTemplate.query(sql, new RowMapper<Student>() {
				
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student = new Student();

					student.setId(rs.getInt("id"));
					student.setStudentName(rs.getString("StudentName"));
					student.setEmailId(rs.getString("emailId"));
					

					return student;
				}

			});
		}

		@Override
		public List<Student> findStudentById(int studentId) {
			List<Student> studentList = jdbcTemplate.query("SELECT * FROM STUDENT where id=?",
					new Object[] { studentId }, new RowMapper<Student>() {

						@Override
						public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
							Student student = new Student();

							student.setId(rs.getInt("id"));
							student.setStudentName(rs.getString("StudentName"));
							student.setEmailId(rs.getString("emailId"));
							return student;
							

							
						}

					});

			return studentList;
			
		}
		@Override
		public int  updateById(Student student) {
			
			System.out.println("inside by ids");
			String sql="update Student set StudentName=?,emailId=? where id=?";
			
				int counter=	jdbcTemplate.update(sql, new Object[] {student.getStudentName(),student.getEmailId(),student.getId()});
				System.out.println(sql);
				return counter;
		}

		@Override
		public int delete(int studentId) {
			
			System.out.println("inside daoimp");
		       String sql="delete from Student where id=?";
				
				  int count=jdbcTemplate.update(sql, new Object[] {studentId});
				  System.out.println(sql);
				  return count;

			
		}
}
