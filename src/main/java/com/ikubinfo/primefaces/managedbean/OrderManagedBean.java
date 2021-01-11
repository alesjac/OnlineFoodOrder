package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.event.UnselectEvent;
import org.springframework.web.context.annotation.RequestScope;

import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.service.ClientService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name="orderBean")
@RequestScope
public class OrderManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Sustenance> beverages;
	
	private List<Sustenance> starters;
	private List<Sustenance> soupChilliSalads;
	private List<Sustenance> burgers;
	private List<Sustenance> desserts;
	private List<Sustenance> subssides;
	
	private String[] selectedBeverages;
	
	
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;
	
	@ManagedProperty(value = "#{messages}")
	private Messages messages;
	
	@ManagedProperty(value = "#{clientLoginManagedBean}")
	private ClientLoginManagedBean clientLoginMB;


	@ManagedProperty(value = "#{menuBean}")
	private ViewMenuManagedBean viewMenuMB;
	
	@PostConstruct
	public void init() {
		beverages=viewMenuMB.getBeverages();
		starters=viewMenuMB.getStarters();
		soupChilliSalads=viewMenuMB.getSoupChilliSalads();
		burgers=viewMenuMB.getBurgers();
		desserts=viewMenuMB.getDesserts();
		subssides=viewMenuMB.getSubstitutionSides();
		
		
	}

	public void onItemUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
         
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
         
        context.addMessage(null, msg);
    }
	
	public List<Sustenance> getBeverages() {
		return beverages;
	}

	public void setBeverages(List<Sustenance> beverages) {
		this.beverages = beverages;
	}

	public List<Sustenance> getStarters() {
		return starters;
	}

	public void setStarters(List<Sustenance> starters) {
		this.starters = starters;
	}

	public List<Sustenance> getSoupChilliSalads() {
		return soupChilliSalads;
	}

	public void setSoupChilliSalads(List<Sustenance> soupChilliSalads) {
		this.soupChilliSalads = soupChilliSalads;
	}

	public List<Sustenance> getBurgers() {
		return burgers;
	}

	public void setBurgers(List<Sustenance> burgers) {
		this.burgers = burgers;
	}

	public List<Sustenance> getDesserts() {
		return desserts;
	}

	public void setDesserts(List<Sustenance> desserts) {
		this.desserts = desserts;
	}

	public List<Sustenance> getSubssides() {
		return subssides;
	}

	public void setSubssides(List<Sustenance> subssides) {
		this.subssides = subssides;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public ClientLoginManagedBean getClientLoginMB() {
		return clientLoginMB;
	}

	public void setClientLoginMB(ClientLoginManagedBean clientLoginMB) {
		this.clientLoginMB = clientLoginMB;
	}

	public ViewMenuManagedBean getViewMenuMB() {
		return viewMenuMB;
	}

	public void setViewMenuMB(ViewMenuManagedBean viewMenuMB) {
		this.viewMenuMB = viewMenuMB;
	}

	public String[] getSelectedBeverages() {
		return selectedBeverages;
	}

	public void setSelectedBeverages(String[] selectedBeverages) {
		this.selectedBeverages = selectedBeverages;
	}
	
	
	
	
}
