package com.ikubinfo.primefaces.repository.mapper;
import com.ikubinfo.primefaces.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginAdminRowMapper  implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getInt("admin_id"));
		admin.setName(rs.getString("name"));
		admin.setSurname(rs.getString("surname"));
		admin.setUsername(rs.getString("username"));
		admin.setPassword(rs.getString("password"));
		return admin;
	}

}
