package com.lab21.Lab21Demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lab21.entity.Person;
import com.lab21.entity.items;

@Repository
public class userDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<items> findAll() {
		String sql = "SELECT * FROM items";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(items.class));
	}
	
	public void addUser(Person p) {
		String sql = "INSERT INTO users (fname, lname) VALUES (?, ?)";

		jdbcTemplate.update(sql, p.getFirstName(), p.getLastName());
	}



}
