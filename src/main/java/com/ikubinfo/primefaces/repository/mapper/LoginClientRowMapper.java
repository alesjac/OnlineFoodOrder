package com.ikubinfo.primefaces.repository.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.ikubinfo.primefaces.model.Client;

public class LoginClientRowMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setId(rs.getInt("client_id"));
		client.setName(rs.getString("name"));
		client.setSurname(rs.getString("surname"));
		client.setUsername(rs.getString("username"));
		client.setPassword(rs.getString("password"));
		client.setBirthday(rs.getDate("birthday"));
		return client;
	}

}
