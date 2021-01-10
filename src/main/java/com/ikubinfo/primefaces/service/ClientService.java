package com.ikubinfo.primefaces.service;

import java.util.List;

import com.ikubinfo.primefaces.model.Client;

public interface ClientService {
	boolean clientLogin(String username,String password);
	List<Client> getClientByUsername(String username);
	boolean changePassword(String newPassword, String username);
    boolean registerClient(Client client);
}
