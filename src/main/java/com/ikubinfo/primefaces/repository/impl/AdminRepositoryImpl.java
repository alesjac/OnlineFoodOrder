package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
	private SimpleJdbcInsert insertCategoryQuery;
	@Autowired
	public AdminRepositoryImpl(DataSource datasource) {
		super();
	
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		this.jdbcTemplate=new JdbcTemplate(datasource);
		this.insertCategoryQuery=new SimpleJdbcInsert(datasource).withTableName("sustenance").usingGeneratedKeyColumns("id");

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
		Map<String,Object>parameters=new HashMap<String, Object>();
		parameters.put("name", sustenance.getName());
		parameters.put("ingredients", sustenance.getIngredients());
		parameters.put("price", sustenance.getPrice());
		parameters.put("menu_section_id", 1);
		
		return insertCategoryQuery.execute(parameters)>0;
		
	}


	@Override
	public boolean addStarters(Sustenance susten) {
		Map<String,Object>parameters=new HashMap<String, Object>();
		parameters.put("name", susten.getName());
		parameters.put("ingredients", susten.getIngredients());
		parameters.put("price", susten.getPrice());
		parameters.put("menu_section_id", 2);
		return insertCategoryQuery.execute(parameters)>0;
	}





}
