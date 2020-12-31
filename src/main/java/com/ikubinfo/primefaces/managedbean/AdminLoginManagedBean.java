package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.service.LoginAdminService;


@ManagedBean
@RequestScoped
public class AdminLoginManagedBean{
	private String username;
	private String password;
	private String name;
	private String surname;
	private Admin admin;
	
	@ManagedProperty(value= "#{loginAdminService}")
	private LoginAdminService loginAdminService;
	
	@PostConstruct
	public void init() {
		admin=loginAdminService.getAdmin();
		
	}

	
	

	public void login() throws IOException {
		FacesMessage message = null;
		boolean loggedIn = false;

		if (username != null && username.equals(admin.getUsername()) && password != null
				&& password.equals(admin.getPassword())) {
			loggedIn = true;
			FacesContext.getCurrentInstance().getExternalContext().redirect("adminPage.xhtml");
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		
	}




	public Admin getAdmin() {
		return admin;
	}




	public void setAdmin(Admin admin) {
		this.admin = admin;
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




	
	
}
