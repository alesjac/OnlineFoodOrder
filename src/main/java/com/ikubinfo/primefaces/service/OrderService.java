package com.ikubinfo.primefaces.service;

import com.ikubinfo.primefaces.model.User;

public interface OrderService {

	boolean addClientDetailsOrder(User user, String address, int number);

	boolean addFoodDetailsOrder(int clientId, int susId);

}
