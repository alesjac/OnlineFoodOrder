package com.ikubinfo.primefaces.repository.impl;

import java.util.List;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.repository.ViewMenuRepository;
import com.ikubinfo.primefaces.repository.mapper.ViewMenuRowMapper;


@Repository
public class ViewMenuRepositoryImpl implements ViewMenuRepository {
	private static final String GET_BEVERAGES = "SELECT * FROM sustenance \r\n" + 
			"INNER JOIN menu ON sustenance.menu_section_id=menu.menu_section_id\r\n" + 
			"WHERE menu.menu_section_id=1";
	
	private static final String GET_STARTERS = "SELECT * FROM sustenance \r\n" + 
			"INNER JOIN menu ON sustenance.menu_section_id=menu.menu_section_id\r\n" + 
			"WHERE menu.menu_section_id=2";
	
	private static final String GET_SoupChilliSalads = "SELECT * FROM sustenance \r\n" + 
			"INNER JOIN menu ON sustenance.menu_section_id=menu.menu_section_id\r\n" + 
			"WHERE menu.menu_section_id=3";
	
	private static final String GET_BURGERS = "SELECT * FROM sustenance \r\n" + 
			"INNER JOIN menu ON sustenance.menu_section_id=menu.menu_section_id\r\n" + 
			"WHERE menu.menu_section_id=4";
	
	private static final String GET_DESSERTS = "SELECT * FROM sustenance \r\n" + 
			"INNER JOIN menu ON sustenance.menu_section_id=menu.menu_section_id\r\n" + 
			"WHERE menu.menu_section_id=5";
	
	private static final String GET_SUSBTSIDE = "SELECT * FROM sustenance \r\n" + 
			"INNER JOIN menu ON sustenance.menu_section_id=menu.menu_section_id\r\n" + 
			"WHERE menu.menu_section_id=6";
	
	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcInsert insertCategoryQuery;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ViewMenuRepositoryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		//this.insertCategoryQuery = new SimpleJdbcInsert(datasource).withTableName("category")
				//.usingGeneratedKeyColumns("category_id");
	    //	this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	

	@Override
	public List<Sustenance> getBeverages() {
		
		return namedParameterJdbcTemplate.query(GET_BEVERAGES, new ViewMenuRowMapper());
	}

	@Override
	public List<Sustenance> getStarters() {
		
		return namedParameterJdbcTemplate.query(GET_STARTERS, new ViewMenuRowMapper());
	}

	@Override
	public List<Sustenance> getSoupChilliSalads() {
		
		return namedParameterJdbcTemplate.query(GET_SoupChilliSalads, new ViewMenuRowMapper());
	}

	@Override
	public List<Sustenance> getBurgers() {
		
		return namedParameterJdbcTemplate.query(GET_BURGERS, new ViewMenuRowMapper());
	}

	@Override
	public List<Sustenance> getDesserts() {
		
		return namedParameterJdbcTemplate.query(GET_DESSERTS, new ViewMenuRowMapper());
	}

	@Override
	public List<Sustenance> getSubstitutionSides() {
		
		return namedParameterJdbcTemplate.query(GET_SUSBTSIDE, new ViewMenuRowMapper());
	}

}
