package com.ikubinfo.primefaces.repository.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.repository.LoginAdminRepository;
import com.ikubinfo.primefaces.repository.mapper.LoginAdminRowMapper;

@Repository
public class LoginAdminRepositoryImpl implements LoginAdminRepository {

	private static final String GET_ADMIN ="SELECT * FROM admin WHERE 1=1";
	

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public LoginAdminRepositoryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		
	}
	
	
	@Override
	public Admin getAdmin() {
		return (Admin) namedParameterJdbcTemplate.query(GET_ADMIN, new LoginAdminRowMapper());
	}
}
