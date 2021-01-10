package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.service.AdminService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminManagedBean implements Serializable {

	private static final long serialVersionUID = 3800933422824282320L;
	private String username;
	private String password;

	@ManagedProperty(value = "#{adminService}")
	private AdminService adminService;
	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {

	}

	public Admin getAdminByUsername() {
		Admin administrator = new Admin();
		for (Admin adminLoop : adminService.getAdminByUsername(username)) {
			administrator = adminLoop;
		}
		return administrator;
	}

	public void login() throws IOException {

		if (adminService.adminLogin(username, password) == true) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("adminPage.xhtml");

		} else {
			messages.showErrorMessage("Login Error. Invalid credentials");
		}
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

}
