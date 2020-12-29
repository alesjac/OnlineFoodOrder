package com.ikubinfo.primefaces.model;

import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private String address;
	private int quantity;
	private Date orderDate;
	List<Sustenance> sustenances;
	List<Client> client;

	public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<Sustenance> getSustenances() {
		return sustenances;
	}

	public void setSustenances(List<Sustenance> sustenances) {
		this.sustenances = sustenances;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + id;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((sustenances == null) ? 0 : sustenances.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (id != other.id)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (quantity != other.quantity)
			return false;
		if (sustenances == null) {
			if (other.sustenances != null)
				return false;
		} else if (!sustenances.equals(other.sustenances))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", address=" + address + ", quantity=" + quantity + ", orderDate=" + orderDate
				+ ", sustenances=" + sustenances + ", client=" + client + "]";
	}

}
