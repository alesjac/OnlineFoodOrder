package com.ikubinfo.primefaces.service.impl;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.repository.UserRepository;
import com.ikubinfo.primefaces.service.UserService;
import com.ikubinfo.primefaces.service.exceptions.UserErrors;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserRepository userRep;

	public UserServiceImpl(UserRepository userRep) {
		this.userRep = userRep;
	}

	@Override
	public boolean isLogged(String username, String password) {
		boolean usernm = userRep.usernameExists(username);
		boolean pass = userRep.passwordExists(password);

		if (usernm == true && pass == true) {
			return true;
		} else {
			return false;
		}

	}
	@Override
	public User findUser(String username, String password) {
		return userRep.findUser(username, password);
	}


	@Override
	public boolean changePassword(String newPassword, String username) {
		return userRep.changePassword(newPassword, username);

	}

	@Override
	public boolean registerClient(User user) {
		if (userRep.usernameExists(user.getUsername())) {
			throw new UserErrors("Please try another username!");

		} else {

			return userRep.registerClient(user);

		}
	}

	@Override
	public User getUserByUsername(String username) {
		return userRep.getUserByUsername(username);
	}

	
}
