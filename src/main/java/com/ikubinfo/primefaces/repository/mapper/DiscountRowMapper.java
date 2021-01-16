package com.ikubinfo.primefaces.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ikubinfo.primefaces.model.Discount;

public class DiscountRowMapper implements RowMapper<Discount> {

	@Override
	public Discount mapRow(ResultSet rs, int rowNum) throws SQLException {
		Discount discount = new Discount();
		discount.setId(rs.getInt("discount_id"));
		discount.setState(rs.getString("discount_state"));
		discount.setPercentDiscount(rs.getInt("percent"));
		return discount;
	}

}