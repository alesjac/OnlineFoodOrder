package com.ikubinfo.primefaces.repository.mapper;

import com.ikubinfo.primefaces.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginEmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return null;
	}

}
