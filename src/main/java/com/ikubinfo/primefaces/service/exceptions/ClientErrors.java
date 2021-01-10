package com.ikubinfo.primefaces.service.exceptions;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ClientErrors extends RuntimeException{
	private static final long serialVersionUID =1L;

	public ClientErrors(String message) {
		super(message);

	}

	public void showErrorMessage(String message) {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}
}
