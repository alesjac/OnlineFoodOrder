package com.ikubinfo.primefaces.model;

public class SustenanceAndOrderDetails {

	private int susId;
	private String susName;
	private double susPrice;
	private int susQuantityOrdered;

	public SustenanceAndOrderDetails() {
		super();
	}

	public int getSusId() {
		return susId;
	}

	public void setSusId(int susId) {
		this.susId = susId;
	}

	public String getSusName() {
		return susName;
	}

	public void setSusName(String susName) {
		this.susName = susName;
	}

	public double getSusPrice() {
		return susPrice;
	}

	public void setSusPrice(double susPrice) {
		this.susPrice = susPrice;
	}

	public int getSusQuantityOrdered() {
		return susQuantityOrdered;
	}

	public void setSusQuantityOrdered(int susQuantityOrdered) {
		this.susQuantityOrdered = susQuantityOrdered;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + susId;
		result = prime * result + ((susName == null) ? 0 : susName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(susPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + susQuantityOrdered;
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
		SustenanceAndOrderDetails other = (SustenanceAndOrderDetails) obj;
		if (susId != other.susId)
			return false;
		if (susName == null) {
			if (other.susName != null)
				return false;
		} else if (!susName.equals(other.susName))
			return false;
		if (Double.doubleToLongBits(susPrice) != Double.doubleToLongBits(other.susPrice))
			return false;
		if (susQuantityOrdered != other.susQuantityOrdered)
			return false;
		return true;
	}

}
