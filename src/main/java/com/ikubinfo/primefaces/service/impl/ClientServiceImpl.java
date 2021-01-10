package com.ikubinfo.primefaces.service.impl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.repository.ClientRepository;
import com.ikubinfo.primefaces.service.ClientService;
import com.ikubinfo.primefaces.service.exceptions.ClientErrors;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRep;

	public ClientServiceImpl(ClientRepository clientRep) {
		this.clientRep = clientRep;
	}

	@Override
	public boolean clientLogin(String username, String password) {
		boolean usernm = clientRep.usernameExists(username);
		boolean pass = clientRep.passwordExists(password);

		if (usernm == true && pass == true) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Client> getClientByUsername(String username) {
		return clientRep.getClientByUsername(username);
	}

	@Override
	public boolean changePassword(String newPassword, String username) {
		return clientRep.changePassword(newPassword, username);

	}

	@Override
	public boolean registerClient(Client client) {
		if (clientRep.usernameExists(client.getUsername())) {
			throw new ClientErrors("Please try another username!");

		} else {

			return clientRep.registerClient(client);

		}
	}
}
