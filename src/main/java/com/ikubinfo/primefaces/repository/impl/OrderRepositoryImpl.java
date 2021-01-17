package com.ikubinfo.primefaces.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.ClientDetailsOrder;
import com.ikubinfo.primefaces.model.SustenanceAndOrderDetails;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.repository.OrderRepository;
import com.ikubinfo.primefaces.repository.mapper.ClientDetailsOrderRowMapper;
import com.ikubinfo.primefaces.repository.mapper.SusAndOrderDetailsRowMapper;


@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private static final String GET_CLIENT_DETAILS ="SELECT * FROM client_details_order WHERE client_id=? AND address=? AND phone_number=?";
	private static final String SELECTED_SUSTENANCE_ORDER="select sustenance.id,sustenance.name,sustenance.price,food_details_order.quantity from food_details_order\r\n" + 
			"inner join sustenance on food_details_order.sus_id=sustenance.id\r\n" + 
			"where food_details_order.client_details_id=:clientid AND sustenance.menu_section_id=:menuid";
	
	private static final String QUANTITY_QUERY="update food_details_order set quantity=:quantity where sus_id=:susid and client_details_id=:clid ";
	
	private static final String DELETE_SUS_FROM_ORDER="delete from food_details_order where client_details_id=:clientdetails AND sus_id=:susid";

	
	
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
		
		paramters.put("sus_id", susId);
		paramters.put("quantity", 1);
		paramters.put("client_details_id", clientId);

		return insertFoodDetails.execute(paramters) > 0;
	}
   
   @Override
   public ClientDetailsOrder clientDetails(int id, String address, int phone) {
		Map<String, Object> params = new HashMap<>();
		params.put("client_id", id);
		params.put("address", address);
		params.put("phone_number", phone);
		try {
		return jdbcTemplate.queryForObject(GET_CLIENT_DETAILS, new Object[] { id, address,phone },
		new ClientDetailsOrderRowMapper());
		} catch (EmptyResultDataAccessException e) {
		return null;
		}
		}

 
   @Override
   public List<SustenanceAndOrderDetails> getSusOrderedDetails(int clientDetailsId, int menuSectionId) {
	   Map<String, Object> params = new HashMap<>();
		params.put("clientid", clientDetailsId);
		params.put("menuid", menuSectionId);
		try {
		return namedParameterJdbcTemplate.query(SELECTED_SUSTENANCE_ORDER, params, new SusAndOrderDetailsRowMapper());
		} catch (EmptyResultDataAccessException e) {
		return null;
		}
   }
   @Override
   public boolean addQuantity(int quantity,int clientDetailsId, int susId) {
	   MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	   namedParameters.addValue("quantity", quantity+1);
	   namedParameters.addValue("susid", susId);
	   namedParameters.addValue("clid", clientDetailsId);
	   
	   
	   return namedParameterJdbcTemplate.update(QUANTITY_QUERY, namedParameters)>0;
   }
   
   
   @Override
   public boolean decreaseQuantity(int quantity,int clientDetailsId, int susId) {
	   MapSqlParameterSource namedParameters = new MapSqlParameterSource();
	   namedParameters.addValue("quantity", quantity-1);
	   namedParameters.addValue("susid", susId);
	   namedParameters.addValue("clid", clientDetailsId);
	   
	   
	   return namedParameterJdbcTemplate.update(QUANTITY_QUERY, namedParameters)>0;
   }

   
   
   @Override
	public void deleteSusFromOrder(int clientDetails,int susId) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		namedParameters.addValue("clientdetails",clientDetails);
		namedParameters.addValue("susid", susId);

		this.namedParameterJdbcTemplate.update(DELETE_SUS_FROM_ORDER, namedParameters);

	}
}
