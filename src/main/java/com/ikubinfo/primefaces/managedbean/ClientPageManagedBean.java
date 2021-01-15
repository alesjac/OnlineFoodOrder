package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.service.UserService;

import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name="clientBean")
@SessionScoped
public class ClientPageManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

	private String username;
	private User user;

	private String oldPasswordTyped;
	private String newPassword;
	private String newPasswordRetyped;
	
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	
	@ManagedProperty(value = "#{messages}")
	private Messages messages;
	
	
	@PostConstruct
	public void init() {		

	}

	

	

//	public void changePassword() {
//		if(oldPasswordTyped.equals(clientLoginMB.getPassword()) && newPassword.equals(newPasswordRetyped)) {
//			clientService.changePassword(newPassword, clientLoginMB.getUsername());
//			messages.showInfoMessage(" *Your password was succefully changed* ");
//		}else {
//			messages.showErrorMessage("Incorrect old password or new passwords! TRY AGAIN");
//
//		}
//	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
