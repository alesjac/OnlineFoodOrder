package com.ikubinfo.primefaces.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.repository.LoginClientRepository;

@Repository
public class LoginClientReposiotryImpl implements LoginClientRepository {

	@Override
	public List<Client> getClient(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getClientByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
