package com.ikubinfo.primefaces.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.web.context.annotation.RequestScope;

import com.ikubinfo.primefaces.model.ClientDetailsOrder;
import com.ikubinfo.primefaces.model.Order;
import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.model.SustenanceAndOrderDetails;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.service.OrderService;
import com.ikubinfo.primefaces.service.UserService;
import com.ikubinfo.primefaces.service.ViewMenuService;
import com.ikubinfo.primefaces.service.exceptions.UserErrors;
import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private User client;
	private String address;
	private int number;

	private ClientDetailsOrder clientDetails;

	private List<Sustenance> beverages;
	private List<Sustenance> starters;
	private List<Sustenance> soupChilliSalads;
	private List<Sustenance> burgers;
	private List<Sustenance> desserts;
	private List<Sustenance> subssides;

	private List<SustenanceAndOrderDetails> selectedBeverages;
	private List<SustenanceAndOrderDetails> selectedStarters;
	private List<SustenanceAndOrderDetails> selectedSChS;
	private List<SustenanceAndOrderDetails> selectedBurgers;
	private List<SustenanceAndOrderDetails> selectedDesserts;
	private List<SustenanceAndOrderDetails> selectedSubSides;

	private Sustenance selectedBev;
	private SustenanceAndOrderDetails selBevToAddQuantity;
	private SustenanceAndOrderDetails selBevToDecQuantity;
	private SustenanceAndOrderDetails selBevToDeleteQuantity;
	private double totalBev;
	
	private Sustenance selectedStarter;
	private SustenanceAndOrderDetails selStarToAddQuantity;
	private SustenanceAndOrderDetails selStarToDecQuantity;
	private SustenanceAndOrderDetails selStartToDeleteQuantity;
	private double totalStarter;
	
	
	private Sustenance selectedSss;
	private SustenanceAndOrderDetails selSssToAddQuantity;
	private SustenanceAndOrderDetails selSssToDecQuantity;
	private SustenanceAndOrderDetails selSssToDeleteQuantity;
	private double totalSss;
	
	

	private Sustenance selectedBr;
	private SustenanceAndOrderDetails selBrToAddQuantity;
	private SustenanceAndOrderDetails selBrToDecQuantity;
	private SustenanceAndOrderDetails selBrToDeleteQuantity;
	private double totalBr;
	
	

	private Sustenance selectedD;
	private SustenanceAndOrderDetails selDToAddQuantity;
	private SustenanceAndOrderDetails selDToDecQuantity;
	private SustenanceAndOrderDetails selDToDeleteQuantity;
	private double totalD;
	
	
	
	private Sustenance selectedsub;
	private SustenanceAndOrderDetails selsubToAddQuantity;
	private SustenanceAndOrderDetails selsubToDecQuantity;
	private SustenanceAndOrderDetails selsubToDeleteQuantity;
	private double totalsub;
	
	
	

	private Order order;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@ManagedProperty(value = "#{orderService}")
	private OrderService orderService;

	@ManagedProperty(value = "#{viewmenuService}")
	private ViewMenuService viewService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{userBean}")
	private UserManagedBean userBean;

	@PostConstruct
	public void init() {
		beverages = viewService.getBeverages();
		starters = viewService.getStarters();
		soupChilliSalads = viewService.getSoupChilliSalads();
		burgers = viewService.getBurgers();
		desserts = viewService.getDesserts();
		subssides = viewService.getSubstitutionSides();

		selectedBeverages = new ArrayList<SustenanceAndOrderDetails>();
		selectedStarters = new ArrayList<SustenanceAndOrderDetails>();
		selectedBurgers = new ArrayList<SustenanceAndOrderDetails>();
		selectedDesserts = new ArrayList<SustenanceAndOrderDetails>();
		selectedSChS = new ArrayList<SustenanceAndOrderDetails>();
		selectedSubSides =new ArrayList<SustenanceAndOrderDetails>();
		client = new User();
		clientDetails = new ClientDetailsOrder();

		selectedBev = new Sustenance();
		selBevToAddQuantity = new SustenanceAndOrderDetails();
		selBevToDecQuantity = new SustenanceAndOrderDetails();
		selBevToDeleteQuantity = new SustenanceAndOrderDetails();

	}

	
	public void save() {
		double total = totalBev+totalBr+totalD+totalSss+totalStarter+totalsub;
		orderService.receipt(total,clientDetails.getId());
	}
	public void addClientDetails() {
		try {
			int length = String.valueOf(number).length();
			if (!client.getUsername().equals(userBean.getUser().getUsername())) {

				messages.showWarningMessage("Please write your username right!");
			}
			if (length != 9) {
				messages.showWarningMessage("Please write correctly your numberwith 10 digits. Example: 06xxxxxxxx!");
			}
			if (client.getUsername().equals(userBean.getUser().getUsername()) && length == 9) {
				client = userBean.getUser();
				orderService.addClientDetailsOrder(client, address, number);
				messages.showInfoMessage("Details succefully added!");
			}
		} catch (UserErrors e) {
			e.showErrorMessage("Register first to order");
		}

	}

	public ClientDetailsOrder getClientDetailsAfterSave() {
		clientDetails = orderService.clientDetails(client.getId(), address, number);
		return clientDetails;
	}

	public void orderBeverage() {
		clientDetails = orderService.clientDetails(client.getId(), address, number);
		orderService.addFoodDetailsOrder(clientDetails.getId(), selectedBev.getId());

		// continueOrder
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 1);

	}


	public void addBevQuantity() {

		orderService.addQuantity(selBevToAddQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selBevToAddQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 1);

	}

	public void decreaseBevQuantity() {

		orderService.decreaseQuantity(selBevToDecQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selBevToDecQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 1);

	}

	public void deleteBevFromOrder() {
		orderService.deleteSusFromOrder(clientDetails.getId(), selBevToDeleteQuantity.getSusId());
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 1);

	}

	public void getTotalStarterPrice() throws IOException {
		double total = 0;
		for (SustenanceAndOrderDetails sus : selectedBeverages) {

			double prices = sus.getSusPrice() * sus.getSusQuantityOrdered();

			total = total + prices;
			totalStarter = total;

		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("order.xhtml");
	
	}

	
	
	public void orderStarter() {
		clientDetails = orderService.clientDetails(client.getId(), address, number);
		orderService.addFoodDetailsOrder(clientDetails.getId(), selectedStarter.getId());

		// continueOrder
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 2);

	}
	
	public void addStarterQuantity() {

		orderService.addQuantity(selStarToAddQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selStarToAddQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 2);

	}
	
	public void decreaseStarterQuantity() {

		orderService.decreaseQuantity(selStarToDecQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selStarToDecQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 2);

	}

	public void deleteStarterFromOrder() {
		orderService.deleteSusFromOrder(clientDetails.getId(), selStartToDeleteQuantity.getSusId());
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 2);

	}
	
	public void getTotalBevPrice() throws IOException {
		double total = 0;
		for (SustenanceAndOrderDetails sus : selectedStarters) {

			double prices = sus.getSusPrice() * sus.getSusQuantityOrdered();

			total = total + prices;
			totalBev = total;

		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("order.xhtml");
	}
	
	public void orderSss() {
		clientDetails = orderService.clientDetails(client.getId(), address, number);
		orderService.addFoodDetailsOrder(clientDetails.getId(), selectedSss.getId());

		// continueOrder
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 3);

	}
	
	public void addSssQuantity() {

		orderService.addQuantity(selSssToAddQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selSssToAddQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 3);

	}
	
	public void decreaseSssQuantity() {

		orderService.decreaseQuantity(selSssToDecQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selSssToDecQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 3);

	}

	public void deleteSssFromOrder() {
		orderService.deleteSusFromOrder(clientDetails.getId(), selSssToDeleteQuantity.getSusId());
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 3);

	}
	
	public void getTotalSssPrice() throws IOException {
		double total = 0;
		for (SustenanceAndOrderDetails sus : selectedSChS) {

			double prices = sus.getSusPrice() * sus.getSusQuantityOrdered();

			total = total + prices;
			totalSss = total;

		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("order.xhtml");
		
	}
	
	
	public void orderBr() {
		clientDetails = orderService.clientDetails(client.getId(), address, number);
		orderService.addFoodDetailsOrder(clientDetails.getId(), selectedBr.getId());

		// continueOrder
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 4);

	}
	
	public void addBrQuantity() {

		orderService.addQuantity(selBrToAddQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selBrToAddQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 4);

	}
	
	public void decreaseBrQuantity() {

		orderService.decreaseQuantity(selBrToDecQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selBrToDecQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 4);

	}

	public void deleteBrFromOrder() {
		orderService.deleteSusFromOrder(clientDetails.getId(), selBrToDeleteQuantity.getSusId());
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 4);

	}
	
	public void getTotalBrPrice() throws IOException {
		double total = 0;
		for (SustenanceAndOrderDetails sus : selectedSChS) {

			double prices = sus.getSusPrice() * sus.getSusQuantityOrdered();

			total = total + prices;
			totalBr = total;

		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("order.xhtml");
		
	}
	
	
	
	public void orderD() {
		clientDetails = orderService.clientDetails(client.getId(), address, number);
		orderService.addFoodDetailsOrder(clientDetails.getId(), selectedD.getId());

		// continueOrder
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 5);

	}
	
	public void addDQuantity() {

		orderService.addQuantity(selDToAddQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selDToAddQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 5);

	}
	
	public void decreaseDQuantity() {

		orderService.decreaseQuantity(selDToDecQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selDToDecQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 5);

	}

	public void deleteDFromOrder() {
		orderService.deleteSusFromOrder(clientDetails.getId(), selDToDeleteQuantity.getSusId());
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 5);

	}
	
	public void getTotalDPrice() throws IOException {
		double total = 0;
		for (SustenanceAndOrderDetails sus : selectedSChS) {

			double prices = sus.getSusPrice() * sus.getSusQuantityOrdered();

			total = total + prices;
			totalD = total;

		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("order.xhtml");
		
	}
	
	
	
	public void ordersub() {
		clientDetails = orderService.clientDetails(client.getId(), address, number);
		orderService.addFoodDetailsOrder(clientDetails.getId(), selectedsub.getId());

		// continueOrder
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 6);

	}
	
	public void addsubQuantity() {

		orderService.addQuantity(selsubToAddQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selsubToAddQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 6);

	}
	
	public void decreasesubQuantity() {

		orderService.decreaseQuantity(selsubToDecQuantity.getSusQuantityOrdered(), clientDetails.getId(),
				selsubToDecQuantity.getSusId());

		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 6);

	}

	public void deletesubFromOrder() {
		orderService.deleteSusFromOrder(clientDetails.getId(), selsubToDeleteQuantity.getSusId());
		selectedBeverages = orderService.getSusOrderedDetails(clientDetails.getId(), 6);

	}
	
	public void getTotalsubPrice() throws IOException {
		double total = 0;
		for (SustenanceAndOrderDetails sus : selectedSChS) {

			double prices = sus.getSusPrice() * sus.getSusQuantityOrdered();

			total = total + prices;
			totalsub = total;

		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("order.xhtml");
		
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

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public List<SustenanceAndOrderDetails> getSelectedBeverages() {
		return selectedBeverages;
	}

	public void setSelectedBeverages(List<SustenanceAndOrderDetails> selectedBeverages) {
		this.selectedBeverages = selectedBeverages;
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

	public Sustenance getSelectedBev() {
		return selectedBev;
	}

	public void setSelectedBev(Sustenance selectedBev) {
		this.selectedBev = selectedBev;
	}

	public ViewMenuService getViewService() {
		return viewService;
	}

	public void setViewService(ViewMenuService viewService) {
		this.viewService = viewService;
	}

	public UserManagedBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserManagedBean userBean) {
		this.userBean = userBean;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setClientDetails(ClientDetailsOrder clientDetails) {
		this.clientDetails = clientDetails;
	}

	public ClientDetailsOrder getClientDetails() {
		return clientDetails;
	}

	public SustenanceAndOrderDetails getSelBevToAddQuantity() {
		return selBevToAddQuantity;
	}

	public void setSelBevToAddQuantity(SustenanceAndOrderDetails selBevToAddQuantity) {
		this.selBevToAddQuantity = selBevToAddQuantity;
	}

	public SustenanceAndOrderDetails getSelBevToDecQuantity() {
		return selBevToDecQuantity;
	}

	public void setSelBevToDecQuantity(SustenanceAndOrderDetails selBevToDecQuantity) {
		this.selBevToDecQuantity = selBevToDecQuantity;
	}

	public SustenanceAndOrderDetails getSelBevToDeleteQuantity() {
		return selBevToDeleteQuantity;
	}

	public void setSelBevToDeleteQuantity(SustenanceAndOrderDetails selBevToDeleteQuantity) {
		this.selBevToDeleteQuantity = selBevToDeleteQuantity;
	}

	public double getTotalBev() {
		return totalBev;
	}

	public void setTotalBev(double totalBev) {
		this.totalBev = totalBev;
	}

	public List<SustenanceAndOrderDetails> getSelectedStarters() {
		return selectedStarters;
	}

	public void setSelectedStarters(List<SustenanceAndOrderDetails> selectedStarters) {
		this.selectedStarters = selectedStarters;
	}

	public List<SustenanceAndOrderDetails> getSelectedSChS() {
		return selectedSChS;
	}

	public void setSelectedSChS(List<SustenanceAndOrderDetails> selectedSChS) {
		this.selectedSChS = selectedSChS;
	}

	public List<SustenanceAndOrderDetails> getSelectedBurgers() {
		return selectedBurgers;
	}

	public void setSelectedBurgers(List<SustenanceAndOrderDetails> selectedBurgers) {
		this.selectedBurgers = selectedBurgers;
	}

	public List<SustenanceAndOrderDetails> getSelectedDesserts() {
		return selectedDesserts;
	}

	public void setSelectedDesserts(List<SustenanceAndOrderDetails> selectedDesserts) {
		this.selectedDesserts = selectedDesserts;
	}

	public List<SustenanceAndOrderDetails> getSelectedSubSides() {
		return selectedSubSides;
	}

	public void setSelectedSubSides(List<SustenanceAndOrderDetails> selectedSubSides) {
		this.selectedSubSides = selectedSubSides;
	}

	public Sustenance getSelectedStarter() {
		return selectedStarter;
	}

	public void setSelectedStarter(Sustenance selectedStarter) {
		this.selectedStarter = selectedStarter;
	}

	public SustenanceAndOrderDetails getSelStarToAddQuantity() {
		return selStarToAddQuantity;
	}

	public void setSelStarToAddQuantity(SustenanceAndOrderDetails selStarToAddQuantity) {
		this.selStarToAddQuantity = selStarToAddQuantity;
	}

	public SustenanceAndOrderDetails getSelStarToDecQuantity() {
		return selStarToDecQuantity;
	}

	public void setSelStarToDecQuantity(SustenanceAndOrderDetails selStarToDecQuantity) {
		this.selStarToDecQuantity = selStarToDecQuantity;
	}

	public SustenanceAndOrderDetails getSelStartToDeleteQuantity() {
		return selStartToDeleteQuantity;
	}

	public void setSelStartToDeleteQuantity(SustenanceAndOrderDetails selStartToDeleteQuantity) {
		this.selStartToDeleteQuantity = selStartToDeleteQuantity;
	}

	public double getTotalStarter() {
		return totalStarter;
	}

	public void setTotalStarter(double totalStarter) {
		this.totalStarter = totalStarter;
	}

	public Sustenance getSelectedSss() {
		return selectedSss;
	}

	public void setSelectedSss(Sustenance selectedSss) {
		this.selectedSss = selectedSss;
	}

	public SustenanceAndOrderDetails getSelSssToAddQuantity() {
		return selSssToAddQuantity;
	}

	public void setSelSssToAddQuantity(SustenanceAndOrderDetails selSssToAddQuantity) {
		this.selSssToAddQuantity = selSssToAddQuantity;
	}

	public SustenanceAndOrderDetails getSelSssToDecQuantity() {
		return selSssToDecQuantity;
	}

	public void setSelSssToDecQuantity(SustenanceAndOrderDetails selSssToDecQuantity) {
		this.selSssToDecQuantity = selSssToDecQuantity;
	}

	public SustenanceAndOrderDetails getSelSssToDeleteQuantity() {
		return selSssToDeleteQuantity;
	}

	public void setSelSssToDeleteQuantity(SustenanceAndOrderDetails selSssToDeleteQuantity) {
		this.selSssToDeleteQuantity = selSssToDeleteQuantity;
	}

	public double getTotalSss() {
		return totalSss;
	}

	public void setTotalSss(double totalSss) {
		this.totalSss = totalSss;
	}

	public Sustenance getSelectedBr() {
		return selectedBr;
	}

	public void setSelectedBr(Sustenance selectedBr) {
		this.selectedBr = selectedBr;
	}

	public SustenanceAndOrderDetails getSelBrToAddQuantity() {
		return selBrToAddQuantity;
	}

	public void setSelBrToAddQuantity(SustenanceAndOrderDetails selBrToAddQuantity) {
		this.selBrToAddQuantity = selBrToAddQuantity;
	}

	public SustenanceAndOrderDetails getSelBrToDecQuantity() {
		return selBrToDecQuantity;
	}

	public void setSelBrToDecQuantity(SustenanceAndOrderDetails selBrToDecQuantity) {
		this.selBrToDecQuantity = selBrToDecQuantity;
	}

	public SustenanceAndOrderDetails getSelBrToDeleteQuantity() {
		return selBrToDeleteQuantity;
	}

	public void setSelBrToDeleteQuantity(SustenanceAndOrderDetails selBrToDeleteQuantity) {
		this.selBrToDeleteQuantity = selBrToDeleteQuantity;
	}

	public double getTotalBr() {
		return totalBr;
	}

	public void setTotalBr(double totalBr) {
		this.totalBr = totalBr;
	}

	public Sustenance getSelectedD() {
		return selectedD;
	}

	public void setSelectedD(Sustenance selectedD) {
		this.selectedD = selectedD;
	}

	public SustenanceAndOrderDetails getSelDToAddQuantity() {
		return selDToAddQuantity;
	}

	public void setSelDToAddQuantity(SustenanceAndOrderDetails selDToAddQuantity) {
		this.selDToAddQuantity = selDToAddQuantity;
	}

	public SustenanceAndOrderDetails getSelDToDecQuantity() {
		return selDToDecQuantity;
	}

	public void setSelDToDecQuantity(SustenanceAndOrderDetails selDToDecQuantity) {
		this.selDToDecQuantity = selDToDecQuantity;
	}

	public SustenanceAndOrderDetails getSelDToDeleteQuantity() {
		return selDToDeleteQuantity;
	}

	public void setSelDToDeleteQuantity(SustenanceAndOrderDetails selDToDeleteQuantity) {
		this.selDToDeleteQuantity = selDToDeleteQuantity;
	}

	public double getTotalD() {
		return totalD;
	}

	public void setTotalD(double totalD) {
		this.totalD = totalD;
	}

	public Sustenance getSelectedsub() {
		return selectedsub;
	}

	public void setSelectedsub(Sustenance selectedsub) {
		this.selectedsub = selectedsub;
	}

	public SustenanceAndOrderDetails getSelsubToAddQuantity() {
		return selsubToAddQuantity;
	}

	public void setSelsubToAddQuantity(SustenanceAndOrderDetails selsubToAddQuantity) {
		this.selsubToAddQuantity = selsubToAddQuantity;
	}

	public SustenanceAndOrderDetails getSelsubToDecQuantity() {
		return selsubToDecQuantity;
	}

	public void setSelsubToDecQuantity(SustenanceAndOrderDetails selsubToDecQuantity) {
		this.selsubToDecQuantity = selsubToDecQuantity;
	}

	public SustenanceAndOrderDetails getSelsubToDeleteQuantity() {
		return selsubToDeleteQuantity;
	}

	public void setSelsubToDeleteQuantity(SustenanceAndOrderDetails selsubToDeleteQuantity) {
		this.selsubToDeleteQuantity = selsubToDeleteQuantity;
	}

	public double getTotalsub() {
		return totalsub;
	}

	public void setTotalsub(double totalsub) {
		this.totalsub = totalsub;
	}

	
	
}
