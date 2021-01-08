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
	public List<Client> getClient(String username, String password) {
		return clientRep.getClient(username, password);
	}

	@Override
	public List<Client> getClientByUsername(String username) {
		return clientRep.getClientByUsername(username);
	}

}
