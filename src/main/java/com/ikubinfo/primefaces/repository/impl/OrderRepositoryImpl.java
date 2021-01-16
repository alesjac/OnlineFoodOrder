package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.ClientDetailsOrder;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertCategoryQuery;
	private SimpleJdbcInsert insertFoodDetails;

	@Autowired
	public OrderRepositoryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		this.jdbcTemplate = new JdbcTemplate(datasource);
		this.insertCategoryQuery = new SimpleJdbcInsert(datasource).withTableName("client_details_order").usingGeneratedKeyColumns("id");
		this.insertFoodDetails = new SimpleJdbcInsert(datasource).withTableName("food_details_order")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public boolean addClientDetailsOrder(User user, String address, int number) {
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("client_id", user.getId());
		paramters.put("address", address);
		paramters.put("phone_number", number);
		
		return insertCategoryQuery.execute(paramters) > 0;

	}
   @Override
	public boolean addFoodDetailsOrder(int clientId, int susId) {
		Map<String, Object> paramters = new HashMap<String, Object>();
		paramters.put("client_details_id", clientId);
		paramters.put("sus_id", susId);
		paramters.put("quantity", 1);

		return insertFoodDetails.execute(paramters) > 0;
	}

}
