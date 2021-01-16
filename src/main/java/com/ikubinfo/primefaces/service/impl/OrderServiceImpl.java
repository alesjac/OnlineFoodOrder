package com.ikubinfo.primefaces.service.impl;

import org.springframework.stereotype.Service;

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

//		if (userRep.usernameExists(user.getUsername())) {
			return orderRep.addClientDetailsOrder(user, address, number);

//		} else {
//			throw new UserErrors("Register first to order");
//
//		}

	}

	@Override
	public boolean addFoodDetailsOrder(int clientId, int susId) {
		return orderRep.addFoodDetailsOrder(clientId, susId);
	}

}
