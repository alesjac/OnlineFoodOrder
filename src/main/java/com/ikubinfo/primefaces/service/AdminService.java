package com.ikubinfo.primefaces.service;

import com.ikubinfo.primefaces.model.Sustenance;


public interface AdminService {

	boolean addBeverages(Sustenance bev);

	boolean addStarters(Sustenance susten);

	boolean editSus(Sustenance sus);
	

	
}
