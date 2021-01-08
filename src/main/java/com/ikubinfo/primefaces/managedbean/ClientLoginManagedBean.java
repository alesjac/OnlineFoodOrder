package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.service.ClientService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean
@SessionScoped
public class ClientLoginManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;
	private String username;
	private String password;

	private List<Client> clientList;

	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;
	
	@ManagedProperty(value = "#{messages}")
	private Messages messages;
	

	@PostConstruct
	public void init() {
    clientList=clientService.getClientByUsername(username);
	}

	public Client getClientByUsername() {
		Client c = new Client();
		for (Client client : clientService.getClientByUsername(username)) {
			c = client;
		}
		return c;
	}

	public List<Client> getClients() {
		clientList = clientService.getClient(username, password);

		return clientList;
	}

	public void login() throws IOException {
		//FacesMessage message = null;
		boolean loggedIn = false;

		for (Client client : getClients()) {
			if (username != null && username.equals(client.getUsername()) && password != null
					&& password.equals(client.getPassword())) {
				loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().redirect("clientPage.xhtml");
			} else {
				loggedIn = false;
				messages.showErrorMessage("Login Error. Invalid credentials");
			}
		}
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);

	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}



}
