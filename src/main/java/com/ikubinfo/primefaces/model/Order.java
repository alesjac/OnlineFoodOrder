package com.ikubinfo.primefaces.model;

import java.util.List;  

public class Order {
	private int id;
	private int quantity;
	private int price;
	List<Sustenance> sustenances;

	
	
	public Order() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Sustenance> getSustenances() {
		return sustenances;
	}
	public void setSustenances(List<Sustenance> sustenances) {
		this.sustenances = sustenances;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + price;
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
		if (id != other.id)
			return false;
		if (price != other.price)
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

	
}
