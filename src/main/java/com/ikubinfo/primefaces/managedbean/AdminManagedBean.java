package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.repository.AdminPageRepository;
import com.ikubinfo.primefaces.repository.impl.AdminPageRepositoryImpl;
import com.ikubinfo.primefaces.service.AdminService;
import com.ikubinfo.primefaces.service.UserService;
import com.ikubinfo.primefaces.service.ViewMenuService;
import com.ikubinfo.primefaces.service.impl.AdminServiceImpl;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminManagedBean implements Serializable {

	private static final long serialVersionUID = 3800933422824282320L;
	
	private List<Sustenance> beverages;
	private List<Sustenance> starters;
	private Sustenance beve;
	private Sustenance starter;
	private String username;
	private User user;
	private Sustenance sus;
	
	@ManagedProperty(value = "#{userBean}")
	private UserManagedBean userBean;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{adminService}")
	private AdminService adminService;

	@ManagedProperty(value = "#{viewmenuService}")
	private ViewMenuService viewService;
	
	@ManagedProperty(value = "#{messages}")
	private Messages messages;
	
	

	@PostConstruct
	public void init() {

		user = userService.getUserByUsername(userBean.getUser().getUsername());
		beverages = viewService.getBeverages();
		starters =viewService.getStarters();
		beve = new Sustenance();
		starter = new Sustenance();
		sus = new Sustenance();
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
	
	public void addBev() {
		if (adminService.addBeverages(beve) == true) {
			messages.showInfoMessage(beve.getName() + " beverage succefully added");
		} else {

			messages.showErrorMessage("An error occured");
		}
	}
	
	public void addStarters() {
		if (adminService.addStarters(starter) == true) {
			messages.showInfoMessage(starter.getName() + " starters succefully added");
		} else {
			messages.showErrorMessage("An error occured");
		}
	}

	public void edit() {
		if (adminService.editSus(sus)) {
			messages.showInfoMessage("You successfully added Sustenance");
		}
		sus=new Sustenance();
	
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

	public List<Sustenance> getBeverages() {
		return beverages;
	}

	public void setBeverages(List<Sustenance> beverages) {
		this.beverages = beverages;
	}

	public Sustenance getBeve() {
		return beve;
	}

	public void setBeve(Sustenance beve) {
		this.beve = beve;
	}

	public ViewMenuService getViewService() {
		return viewService;
	}

	public void setViewService(ViewMenuService viewService) {
		this.viewService = viewService;
	}

	public List<Sustenance> getStarters() {
		return starters;
	}

	public void setStarters(List<Sustenance> starters) {
		this.starters = starters;
	}

	public Sustenance getStarter() {
		return starter;
	}

	public void setStarter(Sustenance starter) {
		this.starter = starter;
	}

	public Sustenance getSus() {
		return sus;
	}

	public void setSus(Sustenance sus) {
		this.sus = sus;
	}



	



	
}