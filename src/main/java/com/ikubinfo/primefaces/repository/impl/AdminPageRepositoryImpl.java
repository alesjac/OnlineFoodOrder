package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.repository.AdminPageRepository;


@Repository
public class AdminPageRepositoryImpl implements AdminPageRepository {
	private static final String EDIT_SUSTENANCE="UPDATE sustenance SET name= :name, ingredients= :ingredients, price= :price WHERE id= :id";
    private static final String DELETE_SUSTENANCE="DELETE FROM sustenance WHERE id=:id";
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertCategoryQuery;
	@Autowired
	public AdminPageRepositoryImpl(DataSource datasource) {
		super();
	
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		this.jdbcTemplate=new JdbcTemplate(datasource);
		this.insertCategoryQuery=new SimpleJdbcInsert(datasource).withTableName("sustenance").usingGeneratedKeyColumns("id");

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
	
	
	@Override
	public boolean addSoupChilliSalads(Sustenance sustenan) {
		Map<String,Object>parameters=new HashMap<String, Object>();
		parameters.put("name", sustenan.getName());
		parameters.put("ingredients", sustenan.getIngredients());
		parameters.put("price", sustenan.getPrice());
		parameters.put("menu_section_id", 3);
		return insertCategoryQuery.execute(parameters)>0;
	}
	
	
	@Override
	public boolean editSustenance(Sustenance sus) {
		MapSqlParameterSource namedParameter = new MapSqlParameterSource();
		namedParameter.addValue("name", sus.getName());
		namedParameter.addValue("ingredients", sus.getIngredients());
		namedParameter.addValue("price", sus.getPrice());
		namedParameter.addValue("id", sus.getId());
		
		int updatedCount = this.namedParameterJdbcTemplate.update(EDIT_SUSTENANCE, namedParameter);
		return updatedCount>0;
		
	}

	
	@Override
	public boolean deleteSustenance(Sustenance sustena) {
		MapSqlParameterSource namedParameter = new MapSqlParameterSource();
		
		namedParameter.addValue("id", sustena.getId());
		
		int updatedCount = this.namedParameterJdbcTemplate.update(DELETE_SUSTENANCE, namedParameter);
		return updatedCount>0;
		
	}



	@Override 
	public boolean addBurgers(Sustenance sust) {
		Map<String,Object>parameters=new HashMap<String, Object>();
		parameters.put("name", sust.getName());
		parameters.put("ingredients", sust.getIngredients());
		parameters.put("price", sust.getPrice());
		parameters.put("menu_section_id", 4);
		return insertCategoryQuery.execute(parameters)>0;
	
	}



	@Override 
	public boolean addDesserts(Sustenance sust) {
		Map<String,Object>parameters=new HashMap<String, Object>();
		parameters.put("name", sust.getName());
		parameters.put("ingredients", sust.getIngredients());
		parameters.put("price", sust.getPrice());
		parameters.put("menu_section_id", 5);
		return insertCategoryQuery.execute(parameters)>0;


}
	
	@Override 
	public boolean addSubtitionsSides(Sustenance sust) {
		Map<String,Object>parameters=new HashMap<String, Object>();
		parameters.put("name", sust.getName());
		parameters.put("ingredients", sust.getIngredients());
		parameters.put("price", sust.getPrice());
		parameters.put("menu_section_id", 6);
		return insertCategoryQuery.execute(parameters)>0;
}
}