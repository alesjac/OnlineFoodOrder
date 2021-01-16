package com.ikubinfo.primefaces.repository;

import com.ikubinfo.primefaces.model.User;

public interface OrderRepository {

	boolean addClientDetailsOrder(User user, String address, int number);

	boolean addFoodDetailsOrder(int clientId, int susId);
}
