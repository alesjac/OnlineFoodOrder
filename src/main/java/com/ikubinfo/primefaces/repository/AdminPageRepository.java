package com.ikubinfo.primefaces.repository;


import com.ikubinfo.primefaces.model.Sustenance;

public interface AdminPageRepository {

	boolean addBeverages(Sustenance sustenance);

	boolean addStarters(Sustenance susten);
	
	
	boolean editSustenance(Sustenance sus);
	
}
