package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.service.ClientService;

@ManagedBean
@SessionScoped
public class ClientPageManagedBean implements Serializable{
	private static final long serialVersionUID = 3800933422824282320L;

	private String username;
	private Client client;
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	@ManagedProperty(value="#{clientLoginManagedBean}")
	private ClientLoginManagedBean clientLoginMB;

	@PostConstruct
	public void init() {
		client=getClientByUsername();
		
	}

		public Client getClientByUsername() {
		Client client = new Client();
		for (Client c : clientService.getClientByUsername(clientLoginMB.getUsername())) {
			client = c;
		}
		return client;
	}
		
		
		public String logout() {
			
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "homepage?faces-redirect=true";
			
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

	public ClientLoginManagedBean getClientLoginMB() {
		return clientLoginMB;
	}

	public void setClientLoginMB(ClientLoginManagedBean clientLoginMB) {
		this.clientLoginMB = clientLoginMB;
	}

	

}
