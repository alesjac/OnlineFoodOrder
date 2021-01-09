package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.repository.ClientRepository;
import com.ikubinfo.primefaces.repository.mapper.LoginClientRowMapper;

@Repository
public class ClientReposiotryImpl implements ClientRepository {

	
	
	private static final String GET_CLIENT ="SELECT COUNT(*) FROM client WHERE username =?";
	private static final String GET_CLIENT2 ="SELECT COUNT(*) FROM client WHERE password =?";
	private static final String GET_CLIENT_BY_USERNAME="SELECT * FROM client WHERE username = :username";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public ClientReposiotryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		this.jdbcTemplate=new JdbcTemplate(datasource);
	}
	@Override
	public boolean usernameExists(String username) {
		
		int number = jdbcTemplate.queryForObject(GET_CLIENT, Integer.class,username);
				
		if (number==0) {
			return false;
		}else {
			return true;
		}
		
	}
	
	@Override
	public boolean passwordExists(String password) {
		int number = jdbcTemplate.queryForObject(GET_CLIENT2, Integer.class,password);
		
		if (number==0) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public List<Client> getClientByUsername(String username) {
		Map<String,Object> params = new HashMap<>();
		params.put("username", username);
	
		return  namedParameterJdbcTemplate.query(GET_CLIENT_BY_USERNAME, params, new LoginClientRowMapper());
	}

}
