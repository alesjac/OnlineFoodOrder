package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.web.context.annotation.RequestScope;

import com.ikubinfo.primefaces.model.Order;
import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.service.ClientService;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "orderBean")
@ViewScoped
public class OrderManagedBean implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String address;
	private int number; 

	private List<Sustenance> beverages;
	private List<Sustenance> starters;
	private List<Sustenance> soupChilliSalads;
	private List<Sustenance> burgers;
	private List<Sustenance> desserts;
	private List<Sustenance> subssides;

	private List<Sustenance> selectedBeverages;
	private List<Sustenance> selectedStarters;
	private List<Sustenance> selectedSChS;
	private List<Sustenance> selectedBurgers;
	private List<Sustenance> selectedDesserts;
	private List<Sustenance> selectedSubSides;   
	
	
	private Sustenance selectedBev;
	
	
	
	

	private List<Integer>quantitySelectedBev;
	
	
	private double totalPriceBev=0;
	private boolean visible;
	
	
	private Order order;
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
		beverages = viewMenuMB.getBeverages();
		starters = viewMenuMB.getStarters();
		soupChilliSalads = viewMenuMB.getSoupChilliSalads();
		burgers = viewMenuMB.getBurgers();
		desserts = viewMenuMB.getDesserts();
		subssides = viewMenuMB.getSubstitutionSides();
		
		selectedBeverages=new ArrayList<Sustenance>();
		selectedStarters=new ArrayList<Sustenance>();
		selectedBurgers=new ArrayList<Sustenance>();
		selectedDesserts=new ArrayList<Sustenance>();
		selectedSChS=new ArrayList<Sustenance>();
		selectedSubSides=new ArrayList<Sustenance>();
		
		

	}
	
	public void show() {
		visible=true;
	}
	
	public void hide() {
		visible=false;
	}
	public void totalBev() {
		
		for(Sustenance s : selectedBeverages) {
			double[] price = new double[selectedBeverages.size()];
			for(int i=0;i<price.length;i++) {
			price[i] = s.getPrice();
			
			for (Integer in: quantitySelectedBev) {
				int[]quantity= new int[quantitySelectedBev.size()];
			for(int j=0;j<quantity.length;j++) {
				quantity[j]=in;
				if(i==j) {
					double priceBevEach=price[i]*quantity[j];
					totalPriceBev=totalPriceBev+priceBevEach;
				}
			}
			}
		}
		}
	}

	

	public List<Sustenance> getBeverages() {
		return beverages;
	}
    
	public void test() {
		System.out.println("selected");
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

	public List<Sustenance> getSelectedBeverages() {
		return selectedBeverages;
	}

	public void setSelectedBeverages(List<Sustenance> selectedBeverages) {
		this.selectedBeverages = selectedBeverages;
	}

	public List<Sustenance> getSelectedStarters() {
		return selectedStarters;
	}

	public void setSelectedStarters(List<Sustenance> selectedStarters) {
		this.selectedStarters = selectedStarters;
	}

	public List<Sustenance> getSelectedSChS() {
		return selectedSChS;
	}

	public void setSelectedSChS(List<Sustenance> selectedSChS) {
		this.selectedSChS = selectedSChS;
	}

	public List<Sustenance> getSelectedBurgers() {
		return selectedBurgers;
	}

	public void setSelectedBurgers(List<Sustenance> selectedBurgers) {
		this.selectedBurgers = selectedBurgers;
	}

	public List<Sustenance> getSelectedDesserts() {
		return selectedDesserts;
	}

	public void setSelectedDesserts(List<Sustenance> selectedDesserts) {
		this.selectedDesserts = selectedDesserts;
	}

	public List<Sustenance> getSelectedSubSides() {
		return selectedSubSides;
	}

	public void setSelectedSubSides(List<Sustenance> selectedSubSides) {
		this.selectedSubSides = selectedSubSides;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getTotalPriceBev() {
		return totalPriceBev;
	}

	public void setTotalPriceBev(double totalPriceBev) {
		this.totalPriceBev = totalPriceBev; 
	}

	public List<Integer> getQuantitySelectedBev() {
		return quantitySelectedBev;
	}

	public void setQuantitySelectedBev(List<Integer> quantitySelectedBev) {
		this.quantitySelectedBev = quantitySelectedBev;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Sustenance getSelectedBev() {
		return selectedBev;
	}

	public void setSelectedBev(Sustenance selectedBev) {
		this.selectedBev = selectedBev;
	}


	
	

}
