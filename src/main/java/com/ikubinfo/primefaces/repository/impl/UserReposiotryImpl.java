package com.ikubinfo.primefaces.repository.impl;

import java.time.LocalDate;
import java.util.Calendar;
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

import com.ikubinfo.primefaces.model.Discount;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.repository.UserRepository;
import com.ikubinfo.primefaces.repository.mapper.DiscountRowMapper;
import com.ikubinfo.primefaces.repository.mapper.UserRowMapper;

@Repository
public class UserReposiotryImpl implements UserRepository {

	
	
	private static final String GET_USER_BY_CREDENTIALS ="SELECT * FROM users WHERE username =? AND password=?";
	private static final String GET_USER_BY_USERNAME ="SELECT * FROM users WHERE username =?";
	private static final String USERNAME_EXITS ="SELECT COUNT(*) FROM users WHERE username =?";

	private static final String PASSWORD_EXITS ="SELECT COUNT(*) FROM users WHERE password =?";
	
	private static final String CHANGE_PASSWORD = "update users set  password = :password where username = :username";
	private static final String UPDATE_DICOUNT_ID="update users set discount_id= :discount where username= :username";
	private static final String GET_DISCOUNT="select discount.discount_id,discount.discount_state,discount.percent from users \r\n" + 
			"inner join discount on users.discount_id=discount.discount_id where users.username=?";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertCategoryQuery;

	@Autowired
	public UserReposiotryImpl(DataSource datasource) {
		super();
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
		this.jdbcTemplate=new JdbcTemplate(datasource);
		this.insertCategoryQuery = new SimpleJdbcInsert(datasource).withTableName("users")
				.usingGeneratedKeyColumns("user_id");
	}
	@Override
	public boolean usernameExists(String username) {
		
		int number = jdbcTemplate.queryForObject(USERNAME_EXITS, Integer.class,username);
				
		if (number==0) {
			return false;
		}else {
			return true;
		}
		
	}
	
	@Override
	public boolean passwordExists(String password) {
		int number = jdbcTemplate.queryForObject(PASSWORD_EXITS, Integer.class,password);
		
		if (number==0) {
			return false;
		}else {
			return true;
		}
		
	}


	@Override
	public boolean changePassword(String password, String username) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		namedParameters.addValue("password", password);
		namedParameters.addValue("username", username);
		
		int updatedCount= this.namedParameterJdbcTemplate.update(CHANGE_PASSWORD, namedParameters);
		return updatedCount>0;
	}
	
	@Override
	public boolean updateDiscountId(User user) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		
		namedParameters.addValue("username", user.getUsername());
		
		LocalDate localDate = java.time.LocalDate.now();
		Calendar cal = Calendar.getInstance();
		cal.setTime(user.getBirthday());
		if (localDate.getDayOfMonth() == cal.get(Calendar.DAY_OF_MONTH) && localDate.getMonthValue()==cal.get(Calendar.MONTH)) {
			namedParameters.addValue("discount", 1);
		}else {
			namedParameters.addValue("discount", 2);
		}
		
		
		int updatedCount= this.namedParameterJdbcTemplate.update(UPDATE_DICOUNT_ID, namedParameters);
		System.out.println("Update discount method is running!!!!!!");
		return updatedCount>0;
		
	}
	@Override
	public boolean registerClient(User user) {
		Map<String,Object> paramters=new HashMap<String,Object>();
		paramters.put("name", user.getName());
		paramters.put("surname",user.getSurname());
		paramters.put("username", user.getUsername());
		paramters.put("password", user.getPassword());
		paramters.put("birthday", user.getBirthday());
		paramters.put("role","CLIENT");
		
		
		LocalDate localDate = java.time.LocalDate.now();
		Calendar cal = Calendar.getInstance();
		cal.setTime(user.getBirthday());
		if (localDate.getDayOfMonth() == cal.get(Calendar.DAY_OF_MONTH) && localDate.getMonthValue()==cal.get(Calendar.MONTH)) {
			paramters.put("discount_id", 1);
		}else {
			paramters.put("discount_id", 2);
		}
		
		
		return insertCategoryQuery.execute(paramters)>0;
	}
	
	public User findUser(String username, String password) {
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		try {
		return jdbcTemplate.queryForObject(GET_USER_BY_CREDENTIALS, new Object[] { username, password },
		new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
		return null;
		}
		}
	@Override
	public User getUserByUsername(String username) {
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
	
		try {
		return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME, new Object[] { username},
		new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
		return null;
		}
	}
	@Override
	public Discount getDiscount(String username){
		Map<String, Object> params = new HashMap<>();
		params.put("username",username);
		try {
			return jdbcTemplate.queryForObject(GET_DISCOUNT, new Object[] { username},
			new DiscountRowMapper());
			} catch (EmptyResultDataAccessException e) {
			return null;
			}
		
		
	}


}
