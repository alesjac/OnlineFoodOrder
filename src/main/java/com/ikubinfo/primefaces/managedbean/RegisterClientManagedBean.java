package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.web.context.annotation.SessionScope;

import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.service.UserService;

import com.ikubinfo.primefaces.service.exceptions.UserErrors;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "registerBean")
@SessionScope
public class RegisterClientManagedBean implements Serializable  {
	private static final long serialVersionUID = 3800933422824282320L;

	private User user;
	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
		user = new User();
	}

	public void registerClient() {
		try {
			if(userService.registerClient(user)==true) {
				messages.showInfoMessage("Succefully registed!");
			}else {
				messages.showErrorMessage("errorr");
			}
			

		} catch (UserErrors e) {
			e.showErrorMessage("Invalid username! Try another one.");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	

}
