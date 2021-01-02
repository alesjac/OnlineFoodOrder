package com.ikubinfo.primefaces.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.Client;

import com.ikubinfo.primefaces.repository.LoginClientRepository;
import com.ikubinfo.primefaces.service.LoginClientService;

@Service("loginClientService")
public class LoginClientServiceImpl implements LoginClientService {

	private LoginClientRepository loginClientRep;

	public LoginClientServiceImpl(LoginClientRepository loginClientRep) {
		this.loginClientRep = loginClientRep;
	}

	@Override
	public List<Client> getClient(String username, String password) {
		return loginClientRep.getClient(username, password);
	}

	@Override
	public List<Client> getClientByUsername(String username) {
		return loginClientRep.getClientByUsername(username);
	}

}
