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

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.service.LoginAdminService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean
@SessionScoped
public class AdminLoginManagedBean implements Serializable {

	private static final long serialVersionUID = 3800933422824282320L;
	private String username;
	private String password;
	private String name;
	private String surname;
	private List<Admin> adminList;
	private Admin admin;
	@ManagedProperty(value = "#{loginAdminService}")
	private LoginAdminService loginAdminService;
	@ManagedProperty(value = "#{messages}")
	private Messages messages;
	@PostConstruct
	public void init() {
		//String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("admin_id");
		
	}
	
	public Admin getAdminByUsername() {
		Admin administrator = new Admin();
		for (Admin adminLoop: loginAdminService.getAdminByUsername(username)) {
			administrator=adminLoop;
		}
		return administrator;
	}

	public List<Admin> getAdmins() {
		adminList = loginAdminService.getAdmin(username, password);

		return adminList;
	}

	public void login() throws IOException {
		//FacesMessage message = null;
		boolean loggedIn = false;
		List<Admin> toLoopAdmin = getAdmins();
		for (Admin admin : toLoopAdmin) {
			if (username != null && username.equals(admin.getUsername()) && password != null
					&& password.equals(admin.getPassword())) {
				loggedIn = true;
				FacesContext.getCurrentInstance().getExternalContext().redirect("adminPage.xhtml");
			} else {
				loggedIn = false;
				messages.showErrorMessage("Loggin Error. Invalid credentials");
				//message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public LoginAdminService getLoginAdminService() {
		return loginAdminService;
	}

	public void setLoginAdminService(LoginAdminService loginAdminService) {
		this.loginAdminService = loginAdminService;
	}

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	
	
	

}
