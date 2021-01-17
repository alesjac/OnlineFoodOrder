package com.ikubinfo.primefaces.repository.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ikubinfo.primefaces.model.SustenanceAndOrderDetails;


public class SusAndOrderDetailsRowMapper implements RowMapper<SustenanceAndOrderDetails> {

	@Override
	public SustenanceAndOrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		SustenanceAndOrderDetails susOrdered = new SustenanceAndOrderDetails();
		
		susOrdered.setSusId(rs.getInt("id"));
		susOrdered.setSusName(rs.getString("name"));
		susOrdered.setSusPrice(rs.getDouble("price"));
		susOrdered.setSusQuantityOrdered(rs.getInt("quantity"));
		return susOrdered;
		
	}

}
