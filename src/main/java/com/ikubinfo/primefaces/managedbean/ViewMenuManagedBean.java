package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.service.ViewMenuService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "menuBean")
@SessionScoped
public class ViewMenuManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

	private List<Sustenance> beverages;
	
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
		starters = viewMenuService.getStarters();
		soupChilliSalads = viewMenuService.getSoupChilliSalads();
		burgers = viewMenuService.getBurgers();
		desserts = viewMenuService.getDesserts();
		subssides = viewMenuService.getSubstitutionSides();
	}


	public void getAllBev() {
		beverages = viewMenuService.getBeverages();
	}
	




	public void getAllBeverages() {
		beverages = viewMenuService.getBeverages();

	}

	public void getAllStarters() {
		starters = viewMenuService.getStarters();
	}

	public void getAllSoupChillSal() {
		soupChilliSalads = viewMenuService.getSoupChilliSalads();

	}

	public void getAllBurgers() {
		burgers = viewMenuService.getBurgers();
	}

	public void getAllDesserts() {
		desserts = viewMenuService.getDesserts();
	}

	public void getAllSS() {
		subssides = viewMenuService.getSubstitutionSides();
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

	

}
