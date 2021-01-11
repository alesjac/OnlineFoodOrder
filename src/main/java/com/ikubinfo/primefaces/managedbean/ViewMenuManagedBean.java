package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.service.ViewMenuService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "menuBean")
@ViewScoped
public class ViewMenuManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

	private List<Sustenance> beverages;
	private Sustenance beve;
	private Sustenance starter;
	private List<Sustenance> starters;
	private List<Sustenance> soupChilliSalads;
	private List<Sustenance> burgers;
	private List<Sustenance> desserts;
	private List<Sustenance> subssides;

	@ManagedProperty(value = "#{viewmenuService}")
	private ViewMenuService viewMenuService;
	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
		beverages = viewMenuService.getBeverages();
		beve = new Sustenance();
		starter = new Sustenance();
		starters = viewMenuService.getStarters();
		soupChilliSalads = viewMenuService.getSoupChilliSalads();
		burgers = viewMenuService.getBurgers();
		desserts = viewMenuService.getDesserts();
		subssides = viewMenuService.getSubstitutionSides();
	}

	// metodat ...

	public void addBev() {
		if (viewMenuService.addBeverages(beve) == true) {
			messages.showInfoMessage(beve.getName() + " beverage succefully added");
		} else {
			messages.showErrorMessage("An error occured");
		}
	}

	public void addStarters() {
		if (viewMenuService.addStarters(starter) == true) {
			messages.showInfoMessage(starter.getName() + " starters succefully added");
		} else {
			messages.showErrorMessage("An error occured");
		}
	}

	public List<Sustenance> getBeverages() {
		return beverages;

	}

	public List<Sustenance> getStarters() {
		return starters;

	}

	public List<Sustenance> getSoupChilliSalads() {
		return soupChilliSalads;

	}

	public List<Sustenance> getBurgers() {
		return burgers;

	}

	public List<Sustenance> getDesserts() {
		return desserts;

	}

	public List<Sustenance> getSubstitutionSides() {
		return subssides;

	}

	public ViewMenuService getViewMenuService() {
		return viewMenuService;
	}

	public void setViewMenuService(ViewMenuService viewMenuService) {
		this.viewMenuService = viewMenuService;
	}

	public void setBeverages(List<Sustenance> beverages) {
		this.beverages = beverages;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public Sustenance getBeve() {
		return beve;
	}

	public void setBeve(Sustenance beve) {
		this.beve = beve;
	}

	public Sustenance getStarter() {
		return starter;
	}

	public void setStarter(Sustenance starter) {
		this.starter = starter;
	}

}
