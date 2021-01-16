package com.ikubinfo.primefaces.model;

public class ClientDetailsOrder {
  
	private int id;
	private int idClient;
	private String address;
	private int number;
	
	
	
	
	public ClientDetailsOrder() {
		super();
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClientDetailsOrder(int id, int idClient, String address, int number) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.address = address;
		this.number = number;
	}
	
	
	
}
