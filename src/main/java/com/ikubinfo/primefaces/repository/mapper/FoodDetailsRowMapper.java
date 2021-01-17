package com.ikubinfo.primefaces.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ikubinfo.primefaces.model.FoodDetailsOrder;


public class FoodDetailsRowMapper implements RowMapper<FoodDetailsOrder> {

	@Override
	public FoodDetailsOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		FoodDetailsOrder foodDetails= new FoodDetailsOrder();
		foodDetails.setId(rs.getInt("id"));
		foodDetails.setSusId(rs.getInt("sus_id"));
		foodDetails.setQuantity(rs.getInt("quantity"));
		foodDetails.setClientDetailsid(rs.getInt("client_details_id"));
		return foodDetails;
	}

}
