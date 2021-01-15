package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.service.UserService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name="userBean")
@SessionScoped
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;
	private User user;
	private String username;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
		user= new User();
	}


	public String login() throws IOException {
      user= userService.findUser(user.getUsername(), user.getPassword());
     
      
      
      if (user==null) {
    	  messages.showErrorMessage("Wrong username or password! Try again");
      }
      else if(user.getRole().equals("ADMIN")) {
    	  FacesContext.getCurrentInstance().getExternalContext().redirect("admin/adminPage.xhtml");
      }
      else if(user.getRole().equals("CLIENT")) {
    	  FacesContext.getCurrentInstance().getExternalContext().redirect("client/clientPage.xhtml");
      }
		return null;
	}

	

	
	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "homepage?faces-redirect=true";

	}
	



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

}
