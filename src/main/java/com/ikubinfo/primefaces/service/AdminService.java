package com.ikubinfo.primefaces.service;

import org.primefaces.event.RowEditEvent;

import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.model.User;

public interface AdminService {
	
	boolean addBeverages(Sustenance beve);

	boolean addStarters(Sustenance starter);

	boolean editSus(Sustenance sus);

}
