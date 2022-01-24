package org.springcrud.springcrudDemo.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springcrud.springcrudDemo.Model.CommunicationDTO;
import org.springcrud.springcrudDemo.Model.Phone;
import org.springcrud.springcrudDemo.Model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDaoImp implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	/*
	 * public StudentDaoImp(DataSource dataSource) { jdbcTemplate = new
	 * JdbcTemplate(dataSource); }
	 */
	// Phone phone=new Phone();

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
			String sql = "insert into Student values(?,?,?,?,?,?)";
			int counter = jdbcTemplate.update(sql, new Object[] { student.getId(), student.getStudentName(),
					student.getCommunicationDTO().getEmailId(), student.getCommunicationDTO().getPhone().getNumber(),
					student.getCommunicationDTO().getPhone().getCountryCode(),student.getAge() });
			return counter;
		} catch (Exception e) {
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
		String sql = "select * from Student ";

		List<Student> studentlist = jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				CommunicationDTO dto = new CommunicationDTO();
				Phone phones = new Phone();
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("StudentName"));
				student.setAge(rs.getInt("Age"));
				phones.setNumber(rs.getString("number"));
				phones.setCountryCode(rs.getString("countryCode"));
				System.out.println(phones.getNumber());
				dto.setPhone(phones);
				dto.setEmailId(rs.getString("emailId"));

				student.setCommunicationDTO(dto);

				System.out.println("inside maprow" + student);

				return student;
			}

		});

		for (Student s : studentlist) {

		}

		// System.out.println(studentlist+"studentlist");
		return studentlist;

	}

	@Override
	public List<Student> findStudentById(int studentId) {

		List<Student> studentList = jdbcTemplate.query("SELECT * FROM STUDENT where id=?", new Object[] { studentId },
				new RowMapper<Student>() {

					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();
						CommunicationDTO dto = new CommunicationDTO();
						Phone phones = new Phone();
						student.setId(rs.getInt("id"));
						student.setStudentName(rs.getString("StudentName"));
						student.setAge(rs.getInt("Age"));
						dto.setEmailId(rs.getString("emailId"));
						phones.setNumber(rs.getString("number"));
						phones.setCountryCode(rs.getString("countryCode"));

						dto.setPhone(phones);
						student.setCommunicationDTO(dto);
						return student;

					}

				});

		return studentList;

	}

	@Override
	public int updateById(Student student) {

		System.out.println("inside by ids");
		String sql = "update Student set StudentName=?,emailId=?,number=?,countryCode=?,Age=? where id=?";

		int counter = jdbcTemplate.update(sql,
				new Object[] { student.getStudentName(), student.getCommunicationDTO().getEmailId(), student.getId(),
						student.getCommunicationDTO().getPhone().getNumber(),
						student.getCommunicationDTO().getPhone().getCountryCode(),student.getAge() });
		System.out.println(sql);
		return counter;
	}

	@Override
	public int delete(int studentId) {

		System.out.println("inside daoimp");
		String sql = "delete from Student where id=?";

		int count = jdbcTemplate.update(sql, new Object[] { studentId });
		System.out.println(sql);
		return count;

	}

}
