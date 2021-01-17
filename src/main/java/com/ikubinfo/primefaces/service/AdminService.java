package com.ikubinfo.primefaces.service;

import java.awt.List;

import org.primefaces.event.RowEditEvent;

import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.model.User;

public interface AdminService {
	
	boolean addBeverages(Sustenance beve);

	boolean addStarters(Sustenance starter);
	
	boolean addSoupChilliSalads(Sustenance sustenan);

	boolean addBurgers(Sustenance sust);
	
	boolean editSus(Sustenance sus);
	
    
	boolean deleteSustenance(Sustenance sustena);

	boolean addDesserts(Sustenance dessert);

	boolean addSubtitionsSides(Sustenance subtition);
	
	
}
