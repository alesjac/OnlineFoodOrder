package com.ikubinfo.primefaces.model;

public class Menu {
	private int id;
	private int sectionName;

	public Menu() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSectionName() {
		return sectionName;
	}

	public void setSectionName(int sectionName) {
		this.sectionName = sectionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + sectionName;
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
		Menu other = (Menu) obj;
		if (id != other.id)
			return false;
		if (sectionName != other.sectionName)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", sectionName=" + sectionName + "]";
	}

}
