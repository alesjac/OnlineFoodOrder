package com.ikubinfo.primefaces.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.ClientDetailsOrder;
import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.model.SustenanceAndOrderDetails;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.repository.OrderRepository;
import com.ikubinfo.primefaces.repository.UserRepository;
import com.ikubinfo.primefaces.service.OrderService;
import com.ikubinfo.primefaces.service.exceptions.UserErrors;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRep;
	private UserRepository userRep;

	public OrderServiceImpl(OrderRepository orderRep, UserRepository userRep) {
		this.orderRep = orderRep;
		this.userRep = userRep;
	}

	@Override
	public boolean addClientDetailsOrder(User user, String address, int number) {

		if (userRep.usernameExists(user.getUsername())) {
			return orderRep.addClientDetailsOrder(user, address, number);

		} else {
			throw new UserErrors("Register first to order");

		}

	}

	@Override
	public boolean addFoodDetailsOrder(int clientId, int susId) {
		return orderRep.addFoodDetailsOrder(clientId, susId);
	}
	
	
	@Override
	public ClientDetailsOrder clientDetails(int id, String address, int phone) {
		return orderRep.clientDetails(id, address, phone);
	}

	@Override
	public List<SustenanceAndOrderDetails> getSusOrderedDetails(int clientDetailsId, int menuSectionId) {
		return orderRep.getSusOrderedDetails(clientDetailsId, menuSectionId);
	}

	@Override
	public boolean addQuantity(int quantity, int clientDetailsId, int susId) {
		return orderRep.addQuantity(quantity, clientDetailsId, susId);
	}
	
	@Override
	public boolean decreaseQuantity(int quantity, int clientDetailsId, int susId) {
		return orderRep.decreaseQuantity(quantity, clientDetailsId, susId);
	}

	@Override
	public void deleteSusFromOrder(int clientDetails, int susId) {

		orderRep.deleteSusFromOrder(clientDetails, susId);		
	}

	@Override
	public boolean receipt(double totalPrice, int clDetails) {
		return orderRep.receipt(totalPrice, clDetails);
	}

	
}
