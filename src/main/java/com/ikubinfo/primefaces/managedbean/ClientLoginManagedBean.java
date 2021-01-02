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

import com.ikubinfo.primefaces.service.LoginClientService;

@ManagedBean
@SessionScoped
public class ClientLoginManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;
	private String username;
	private String password;
	private String name;
	private String surname;
	private List<Client> clientList;

	@ManagedProperty(value = "#{loginClientService}")
	private LoginClientService loginClientService;

	@PostConstruct
	public void init() {
	}

	public Client getClientByUsername() {
		Client c = new Client();
		for (Client client : loginClientService.getClientByUsername(username)) {
			c = client;
		}
		return c;
	}

	public List<Client> getClients() {
		clientList = loginClientService.getClient(username, password);

		return clientList;
	}

	public void login() throws IOException {
		FacesMessage message = null;
		boolean loggedIn = false;

		for (Client client : getClients()) {
			if (username != null && username.equals(client.getUsername()) && password != null
					&& password.equals(client.getPassword())) {
				loggedIn = true;
				FacesContext.getCurrentInstance().getExternalContext().redirect("clientPage.xhtml");
			} else {
				loggedIn = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
			}
		}
		
		FacesContext.getCurrentInstance().addMessage(null, message);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public LoginClientService getLoginClientService() {
		return loginClientService;
	}

	public void setLoginClientService(LoginClientService loginClientService) {
		this.loginClientService = loginClientService;
	}

}
