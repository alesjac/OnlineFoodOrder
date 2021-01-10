package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.repository.AdminRepository;
import com.ikubinfo.primefaces.repository.mapper.LoginAdminRowMapper;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

	private static final String GET_ADMIN ="SELECT COUNT(*) FROM admin WHERE username =?";
	private static final String GET_ADMIN2 ="SELECT COUNT(*) FROM admin WHERE password =?";
	private static final String GET_ADMIN_BY_USERNAME="SELECT * FROM admin WHERE username = :username";
	

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdminRepositoryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		this.jdbcTemplate=new JdbcTemplate(datasource);

	}
	
	
	@Override
	public boolean usernameExists(String username) {
		
		int number = jdbcTemplate.queryForObject(GET_ADMIN, Integer.class,username);
				
		if (number==0) {
			return false;
		}else {
			return true;
		}
	}




	@Override
	public boolean passwordExists(String password) {
		int number = jdbcTemplate.queryForObject(GET_ADMIN2, Integer.class,password);
		
		if (number==0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Admin> getAdminByUsername(String username) {
		Map<String,Object> params = new HashMap<>();
		params.put("username", username);
		return namedParameterJdbcTemplate.query(GET_ADMIN_BY_USERNAME, params,  new LoginAdminRowMapper() );

	}


	@Override
	public boolean addBeverages(Sustenance sustenance) {
		// TODO Auto-generated method stub
		return false;
	}





}
