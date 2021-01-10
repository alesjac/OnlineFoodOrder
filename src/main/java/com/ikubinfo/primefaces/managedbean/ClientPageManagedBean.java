package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.service.ClientService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean
@SessionScoped
public class ClientPageManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

	private String username;
	private Client client;

	private String oldPasswordTyped;
	private String newPassword;
	private String newPasswordRetyped;
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	@ManagedProperty(value = "#{clientLoginManagedBean}")
	private ClientLoginManagedBean clientLoginMB;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
		client = getClientByUsername();

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

	public void changePassword() {
		if(oldPasswordTyped.equals(clientLoginMB.getPassword()) && newPassword.equals(newPasswordRetyped)) {
			clientService.changePassword(newPassword, clientLoginMB.getUsername());
			messages.showInfoMessage(" *Your password was succefully changed* ");
		}else {
			messages.showErrorMessage("Incorrect old password or new passwords! TRY AGAIN");

		}
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

	public String getOldPasswordTyped() {
		return oldPasswordTyped;
	}

	public void setOldPasswordTyped(String oldPasswordTyped) {
		this.oldPasswordTyped = oldPasswordTyped;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordRetyped() {
		return newPasswordRetyped;
	}

	public void setNewPasswordRetyped(String newPasswordRetyped) {
		this.newPasswordRetyped = newPasswordRetyped;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

}
