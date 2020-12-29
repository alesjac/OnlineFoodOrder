package com.ikubinfo.primefaces.repository.mapper;

import com.ikubinfo.primefaces.model.Sustenance;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ViewMenuRowMapper implements RowMapper<Sustenance> {

	@Override
	public Sustenance mapRow(ResultSet rs, int rowNum) throws SQLException {

		Sustenance sustenance = new Sustenance();
		sustenance.setId(rs.getInt("id"));
		sustenance.setName(rs.getString("name"));
		sustenance.setIngredients(rs.getString("ingredients"));
		sustenance.setPrice(rs.getDouble("price"));
		sustenance.setMenuSection(rs.getString("menu_section_name"));

		return sustenance;
	}

}
