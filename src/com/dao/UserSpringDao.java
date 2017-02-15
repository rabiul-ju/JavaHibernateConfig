package com.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Login;
import com.model.User;

public class UserSpringDao implements CommonDao{
	
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Integer insert(Object object) {
		// TODO Auto-generated method stub
		User user=(User)object;
		String sql="insert into users set first_name='"+user.getFirstName()+"',last_name='"+user.getLastName()+"'"
				+ ",email='"+user.getEmail()+"',login_id='"+user.getLogin().getId()+"'";
		
		return jdbcTemplate.update(sql);
	}

	@Override
	public int update(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getObjectById(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAllObjects() {
		String sql="Select * from users";
		//return jdbcTemplate.queryForList(sql,new BeanPropertyRowMapper<>(User.class));
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

}
