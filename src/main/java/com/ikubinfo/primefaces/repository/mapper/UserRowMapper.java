package com.ikubinfo.primefaces.repository.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.ikubinfo.primefaces.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setBirthday(rs.getDate("birthday"));
		user.setDiscountId(rs.getInt("discount_id"));
		user.setRole(rs.getString("role"));
		return user;
	}

}
