package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.text.View;
import javax.faces.bean.ManagedProperty;
import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.service.ViewMenuService;

@ManagedBean
@ViewScoped
public class ViewMenuManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

	List<Sustenance> beverages;
	List<Sustenance> starters;
	List<Sustenance> soupChilliSalads;
	List<Sustenance> burgers;
	List<Sustenance> desserts;
	List<Sustenance> subssides;

	@ManagedProperty(value = "#{viewmenuService}")
	private ViewMenuService viewMenuService;

	@PostConstruct
	public void init() {
		beverages = viewMenuService.getBeverages();
		starters= viewMenuService.getStarters();
		soupChilliSalads = viewMenuService.getSoupChilliSalads();
		burgers=viewMenuService.getBurgers();
		desserts=viewMenuService.getDesserts();
		subssides=viewMenuService.getSubstitutionSides();
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

}
