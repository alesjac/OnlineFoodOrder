package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.service.AdminService;
import com.ikubinfo.primefaces.service.UserService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminManagedBean implements Serializable {

	private static final long serialVersionUID = 3800933422824282320L;

	private String username;
	private User user;

	@ManagedProperty(value = "#{userBean}")
	private UserManagedBean userBean;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{adminService}")
	private AdminService adminService;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {

		user = userService.getUserByUsername(userBean.getUser().getUsername());
       
	}

	public User getUserDetails() {
		user = userService.getUserByUsername(userBean.getUser().getUsername());
		return user;
	}

	public void rejectOther() {
		try {
			if (user.getRole().equals("CLIENT")) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().redirect("homepage.xhtml");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserManagedBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserManagedBean userBean) {
		this.userBean = userBean;
	}

}
