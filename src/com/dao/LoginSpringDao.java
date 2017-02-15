package com.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Login;
import com.model.User;

public class LoginSpringDao implements CommonDao{

	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Integer insert(Object object) {
		Login login=(Login)object;
		String sql="insert into login set mobile_number='"+login.getMobileNumber()+"', password='"+login.getPassword()+"'";
		Integer integer=null;
		integer=jdbcTemplate.update(sql);
		return integer;
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
	public Object getObjectById(String mobileNumber) {
		// TODO Auto-generated method stub
//		String sql="select * from Emp99 where id=?";  
//	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
		String sql="select * from login where mobile_number='"+mobileNumber+"'";
		Login login=new Login();
		login=null;
		login= (Login)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Login.class));
		return login;
	}

	@Override
	public List<?> getAllObjects() {
		// TODO Auto-generated method stub
		return null;
	}

}
