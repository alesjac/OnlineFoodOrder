package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.service.UserService;
import com.ikubinfo.primefaces.service.exceptions.UserErrors;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

	private boolean isLogin = false;

	private User user;
	private String username;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
		user = new User();
	}

	public void doRedirct(String url) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().redirect(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyLoginAdmin() {
		if (!this.isLogin) {
			doRedirct("login.xhtml");
		}
		else {

		if (user.getRole().equals("CLIENT")) {
			doRedirct("homepage.xhtml");
		}
		
		}

	}

	public void verifyLoginClient() {
		if (!this.isLogin) {
			doRedirct("login.xhtml");
		}else {

			if (user.getRole().equals("ADMIN")) {
				doRedirct("homepage.xhtml");
			}
	}}
//	
	
	public void verifyLogin() {
		if (this.isLogin) {
			if (user.getRole().equals("ADMIN")) {
				doRedirct("adminPage.xhtml");
			}
			if(user.getRole().equals("CLIENT")) {
				doRedirct("clientPage.xhtml");
			}
	}
		}
//	public void verifyLoginViewMenu() {
//		if(!this.isLogin) {
//			doRedirct("login.xhtml");
//		}
//			doRedirct("order.xhtml");
//		}
//	}

	public String login() throws IOException {
		user = userService.findUser(user.getUsername(), user.getPassword());

		if (user == null) {
			String url = "login.xhtml?retry";
			doRedirct(url);
			messages.showErrorMessage("Wrong username or password! Try again");

		} else if (user.getRole().equals("ADMIN")) {
			this.isLogin = true;
			String url = "adminPage.xhtml?username=" + user.getUsername();
			doRedirct(url);
		} else if (user.getRole().equals("CLIENT")) {
			this.isLogin = true;
			String url = "clientPage.xhtml?username=" + user.getUsername();
			doRedirct(url);
		}
		return null;
	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "homepage?faces-redirect=true";

	}

	public void registerClient() throws IOException {
		try {
			if (userService.registerClient(user) == true) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("clientPage.xhtml");

			} else {
				messages.showErrorMessage("Try another username!");
			}

		} catch (UserErrors e) {
			e.showErrorMessage("Invalid username! Try another one.");
		} catch (IOException e) {
			messages.showErrorMessage("error");
		}
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

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}
