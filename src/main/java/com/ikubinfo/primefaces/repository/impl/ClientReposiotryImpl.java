package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.repository.ClientRepository;
import com.ikubinfo.primefaces.repository.mapper.LoginClientRowMapper;

@Repository
public class ClientReposiotryImpl implements ClientRepository {

	
	
	private static final String GET_CLIENT ="SELECT * FROM client WHERE username = :username and password = :password";
	private static final String GET_CLIENT_BY_USERNAME="SELECT * FROM client WHERE username = :username";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public ClientReposiotryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		
	}
	@Override
	public List<Client> getClient(String username, String password) {
		Map<String,Object> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		return namedParameterJdbcTemplate.query(GET_CLIENT, params, new LoginClientRowMapper());
	}

	@Override
	public List<Client> getClientByUsername(String username) {
		Map<String,Object> params = new HashMap<>();
		params.put("username", username);
	
		return namedParameterJdbcTemplate.query(GET_CLIENT_BY_USERNAME, params, new LoginClientRowMapper());
	}

}
