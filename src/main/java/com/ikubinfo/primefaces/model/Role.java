package com.ikubinfo.primefaces.model;

public enum Role {
	 ADMIN("ADMIN"),
	 CLIENT ("CLIENT");
	private String role;

	Role(String role) {
		this.role=role;
	}

	public String getRole() {
		return role;
	}


}
