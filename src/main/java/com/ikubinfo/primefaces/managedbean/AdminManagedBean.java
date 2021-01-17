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
	private List<Sustenance> soupChilliSalads;
	private List<Sustenance> burgers;
	private List<Sustenance> desserts;
	private List<Sustenance> subtitions;
	private Sustenance beve;
	private Sustenance starter;
	private Sustenance soup;
	private Sustenance burger;
	private Sustenance dessert;
	private Sustenance subtition;
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
		soupChilliSalads =viewService.getSoupChilliSalads();
		burgers=viewService.getBurgers();
		desserts=viewService.getDesserts();
		subtitions=viewService.getSubstitutionSides();
		beve = new Sustenance();
		starter = new Sustenance();
		sus = new Sustenance();
		soup = new Sustenance();
		burger = new Sustenance();
		dessert = new Sustenance();
		setSubtition(new Sustenance());
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
	
	public void addBeverages() {
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
	public void addSoups() {
		if (adminService.addSoupChilliSalads(soup) == true) {
			messages.showInfoMessage(soup.getName() + " soup,chilli or salad succefully added");
		} else {
			messages.showErrorMessage("An error occured");
		}
	
	}
	public void addBurgers() {
		if (adminService.addBurgers(burger) == true) {
			messages.showInfoMessage(burger.getName() + " burger succefully added");
		} else {
			messages.showErrorMessage("An error occured");
		}
	
	}
	public void addDesserts() {
		if (adminService.addDesserts(dessert) == true) {
			messages.showInfoMessage(dessert.getName() + " dessert succefully added");
		} else {
			messages.showErrorMessage("An error occured");
		}
	
	}
	public void addSubtitionsSides() {
		if (adminService.addSubtitionsSides(subtition) == true) {
			messages.showInfoMessage(subtition.getName() + " subtituion succefully added");
		} else {
			messages.showErrorMessage("An error occured");
		}
	
	}
	
	

	public void edit() {
		if (adminService.editSus(sus)) {
			messages.showInfoMessage("You successfully editted sustenance");
		}
		else {
			messages.showErrorMessage("Edit not executed!");
		}
	
		}
	public void delete() {
		if (adminService.deleteSustenance(sus)) {
			messages.showInfoMessage("You successfully deleted Sustenance");
		} else {
			messages.showErrorMessage("Edit not executed!");
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

	public List<Sustenance> getSoupChilliSalads() {
		return soupChilliSalads;
	}

	public void setSoupChilliSalads(List<Sustenance> soupChilliSalads) {
		this.soupChilliSalads = soupChilliSalads;
	}

	public Sustenance getSoup() {
		return soup;
	}

	public void setSoup(Sustenance soup) {
		this.soup = soup;
	}

	public List<Sustenance> getBurgers() {
		return burgers;
	}

	public void setBurgers(List<Sustenance> burgers) {
		this.burgers = burgers;
	}

	public Sustenance getBurger() {
		return burger;
	}

	public void setBurger(Sustenance burger) {
		this.burger = burger;
	}

	public List<Sustenance> getDesserts() {
		return desserts;
	}

	public void setDesserts(List<Sustenance> desserts) {
		this.desserts = desserts;
	}

	public Sustenance getDessert() {
		return dessert;
	}

	public void setDessert(Sustenance dessert) {
		this.dessert = dessert;
	}

	public List<Sustenance> getSubtitions() {
		return subtitions;
	}

	public void setSubtitions(List<Sustenance> subtitions) {
		this.subtitions = subtitions;
	}

	public Sustenance getSubtition() {
		return subtition;
	}

	public void setSubtition(Sustenance subtition) {
		this.subtition = subtition;
	}

	
	



	
}