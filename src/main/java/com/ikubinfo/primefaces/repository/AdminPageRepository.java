package com.ikubinfo.primefaces.repository;


import com.ikubinfo.primefaces.model.Sustenance;

public interface AdminPageRepository {

	boolean addBeverages(Sustenance sustenance);

	boolean addStarters(Sustenance susten);
	
	
	boolean editSustenance(Sustenance sus);

	boolean addSoupChilliSalads(Sustenance sustenan);
	
	boolean addBurgers(Sustenance sust);

	boolean deleteSustenance(Sustenance sustena);

	boolean addDesserts(Sustenance sust);

	boolean addSubtitionsSides(Sustenance sust);
	
}
