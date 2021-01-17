package com.ikubinfo.primefaces.model;

public class FoodDetailsOrder {
	private int id; 
	private int susId; 
	private int quantity;
    private int clientDetailsid;


	public FoodDetailsOrder() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getSusId() {
		return susId;
	}



	public void setSusId(int susId) {
		this.susId = susId;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + quantity;
		result = prime * result + susId;
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
		FoodDetailsOrder other = (FoodDetailsOrder) obj;
		if (id != other.id)
			return false;
		if (quantity != other.quantity)
			return false;
		if (susId != other.susId)
			return false;
		return true;
	}



	public int getClientDetailsid() {
		return clientDetailsid;
	}



	public void setClientDetailsid(int clientDetailsid) {
		this.clientDetailsid = clientDetailsid;
	}
	
	

}
