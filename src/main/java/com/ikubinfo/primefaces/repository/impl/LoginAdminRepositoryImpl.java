package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.repository.LoginAdminRepository;
import com.ikubinfo.primefaces.repository.mapper.LoginAdminRowMapper;

@Repository
public class LoginAdminRepositoryImpl implements LoginAdminRepository {

	private static final String GET_ADMIN ="SELECT * FROM admin WHERE username = :username and password = :password";
	private static final String GET_ADMIN_BY_USERNAME="SELECT * FROM admin WHERE username = :username";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public LoginAdminRepositoryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		
	}
	
	
	@Override
	public List<Admin> getAdmin(String username,String password) {
		Map<String,Object> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		return namedParameterJdbcTemplate.query(GET_ADMIN, params, new LoginAdminRowMapper());
	}


	@Override
	public List<Admin> getAdminByUsername(String username) {
		Map<String,Object> params = new HashMap<>();
		params.put("username", username);
		return namedParameterJdbcTemplate.query(GET_ADMIN_BY_USERNAME, params,  new LoginAdminRowMapper() );

	}
}
