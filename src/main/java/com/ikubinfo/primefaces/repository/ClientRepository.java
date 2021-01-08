package com.ikubinfo.primefaces.repository;

import java.util.List;


import com.ikubinfo.primefaces.model.Client;

public interface ClientRepository {
	List<Client> getClient(String username,String password);
	List<Client> getClientByUsername(String username);

}
