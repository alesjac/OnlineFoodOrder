package com.ikubinfo.primefaces.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.repository.ClientRepository;
import com.ikubinfo.primefaces.service.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRep;

	public ClientServiceImpl(ClientRepository loginClientRep) {
		this.clientRep = loginClientRep;
	}

	@Override
	public boolean clientLogin(String username, String password) {
		boolean usernm = clientRep.usernameExists(username);
		boolean pass = clientRep.passwordExists(password);
		
		if (usernm==true && pass==true) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public List<Client> getClientByUsername(String username) {
		return clientRep.getClientByUsername(username);
	}

}
