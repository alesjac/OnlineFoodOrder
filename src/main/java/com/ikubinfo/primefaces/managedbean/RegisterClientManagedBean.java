package com.ikubinfo.primefaces.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.web.context.annotation.SessionScope;

import com.ikubinfo.primefaces.model.Client;
import com.ikubinfo.primefaces.service.ClientService;
import com.ikubinfo.primefaces.service.exceptions.ClientErrors;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "registerBean")
@SessionScope
public class RegisterClientManagedBean {

	private Client client;
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
		client = new Client();
	}

	public void registerClient() {
		try {
			if(clientService.registerClient(client)==true) {
				messages.showInfoMessage("Succefully registed!");
			}else {
				messages.showErrorMessage("errorr");
			}
			

		} catch (ClientErrors e) {
			e.showErrorMessage("Invalid username! Try another one.");
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

}
