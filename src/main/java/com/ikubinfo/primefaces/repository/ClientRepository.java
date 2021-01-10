package com.ikubinfo.primefaces.repository;

import java.util.List;


import com.ikubinfo.primefaces.model.Client;

public interface ClientRepository {
	boolean usernameExists(String username);
	boolean passwordExists(String password);
	List<Client> getClientByUsername(String username);
	boolean changePassword(String password, String username);
	boolean registerClient(Client client);
	//boolean discountOrNot(Client client);
}
