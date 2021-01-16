package com.ikubinfo.primefaces.service;

import java.util.List;

import com.ikubinfo.primefaces.model.Discount;
import com.ikubinfo.primefaces.model.User;

public interface UserService {
	//boolean userLogin(String username,String password);
	User findUser(String username,String password);
	boolean changePassword(String newPassword, String username);
    boolean registerClient(User user);
    User getUserByUsername(String username);
	boolean isLogged(String username, String password);
	public boolean updateDiscountId(User user);
	Discount getDiscount(String username);
}
