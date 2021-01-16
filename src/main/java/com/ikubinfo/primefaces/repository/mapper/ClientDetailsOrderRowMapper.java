package com.ikubinfo.primefaces.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ikubinfo.primefaces.model.ClientDetailsOrder;

public class ClientDetailsOrderRowMapper implements RowMapper<ClientDetailsOrder>  {

	@Override
	public ClientDetailsOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClientDetailsOrder clientDetails= new ClientDetailsOrder();
		clientDetails.setId(rs.getInt("id"));
		clientDetails.setIdClient(rs.getInt("client_id"));
		clientDetails.setAddress(rs.getString("address"));
		clientDetails.setNumber(rs.getInt("phone_number"));
		
		return clientDetails;
	}

	
	
}
