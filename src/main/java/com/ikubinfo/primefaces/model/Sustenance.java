package com.ikubinfo.primefaces.model;

public class Sustenance {
	private int id;
	private String name;
	private String ingredients;
	private String menuSection;
	private double price;

	public Sustenance() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getMenuSection() {
		return menuSection;
	}

	public void setMenuSection(String menuSection) {
		this.menuSection = menuSection;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}
