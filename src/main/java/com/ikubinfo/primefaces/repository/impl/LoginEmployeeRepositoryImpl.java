package com.ikubinfo.primefaces.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Employee;
import com.ikubinfo.primefaces.repository.LoginEmployeeRepository;
import com.ikubinfo.primefaces.repository.mapper.LoginEmployeeRowMapper;

import javax.sql.DataSource;
@Repository
public class LoginEmployeeRepositoryImpl implements LoginEmployeeRepository {

	
	private static final String GET_EMPLOYEE ="SELECT * FROM employee WHERE 1=1";
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public LoginEmployeeRepositoryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		
	}
	
	@Override
	public Employee getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
