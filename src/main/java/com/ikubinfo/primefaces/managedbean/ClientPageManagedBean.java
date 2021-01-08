package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.service.ClientService;

@ManagedBean
@SessionScoped
public class ClientPageManagedBean implements Serializable{
	private static final long serialVersionUID = 3800933422824282320L;

	private String username;
	private Client client;
    private List<Client> clients;
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	@PostConstruct
	public void init() {
		//String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("username");
		//username = value;
		client=getClientUsername();
		clients=clientService.getClientByUsername(username);
	}

		public Client getClientUsername() {
		Client client = new Client();
		for (Client c : clientService.getClientByUsername(username)) {
			client = c;
		}
		return client;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	

}
