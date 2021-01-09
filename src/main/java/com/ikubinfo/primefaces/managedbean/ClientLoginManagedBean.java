package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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

	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
	}


	public void login() throws IOException {
      
		if (clientService.clientLogin(username, password) == true) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("clientPage.xhtml");

		} else {
			messages.showErrorMessage("Login Error. Invalid credentials");
		}
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
