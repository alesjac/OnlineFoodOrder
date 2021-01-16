package com.ikubinfo.primefaces.repository;

import com.ikubinfo.primefaces.model.Discount;
import com.ikubinfo.primefaces.model.User;

public interface UserRepository {
	boolean usernameExists(String username);
	boolean passwordExists(String password);
	User getUserByUsername(String username);
	boolean changePassword(String password, String username);
	boolean registerClient(User client);
	User findUser(String username, String password);
	//boolean discountOrNot(Client client);
	public boolean updateDiscountId(User user);
	
	Discount getDiscount(String username);
	
}
