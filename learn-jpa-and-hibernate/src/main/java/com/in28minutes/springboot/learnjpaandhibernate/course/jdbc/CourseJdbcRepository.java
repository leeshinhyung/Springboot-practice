package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;


@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUEARY = 
			"""
				insert into course (id, name, author)
				values (?, ?, ?)
			""";
	
	private static String DELETE_QUEARY = 
			"""
				delete from course 
				where id = ?
			""";
	
	private static String SELECT_QUEARY = 
			"""
				select * from course 
				where id = ?
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUEARY, 
				course.getId(), course.getName(), course.getAuthor());		
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUEARY, 
				id);		
	}
	
	public Course findById(long id) {
		//ResultSet을 Bean에 매핑하기 => Row Mapper
		//BeanPropertyRowMapper를 사용해서 Course 클래스로 결과를 매핑한다. 
		//id를 입력값으로 보내 그 열만 보여주기 
		
		return springJdbcTemplate.queryForObject(SELECT_QUEARY, new BeanPropertyRowMapper<>(Course.class), id);
	
	}
}
