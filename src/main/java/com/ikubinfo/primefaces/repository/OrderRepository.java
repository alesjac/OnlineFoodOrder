package com.ikubinfo.primefaces.repository;

import java.util.List;

import com.ikubinfo.primefaces.model.ClientDetailsOrder;
import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.model.SustenanceAndOrderDetails;
import com.ikubinfo.primefaces.model.User;

public interface OrderRepository {

	boolean addClientDetailsOrder(User user, String address, int number);

	boolean addFoodDetailsOrder(int clientId, int susId);

	ClientDetailsOrder clientDetails(int id, String address, int phone);

	List<SustenanceAndOrderDetails> getSusOrderedDetails(int clientDetailsId, int menuSectionId);


	boolean addQuantity(int quantity, int clientDetailsId, int susId);

	boolean decreaseQuantity(int quantity, int clientDetailsId, int susId);

	void deleteSusFromOrder(int clientDetails, int susId);

}
