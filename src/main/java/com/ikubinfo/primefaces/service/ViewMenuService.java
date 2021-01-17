package com.ikubinfo.primefaces.service;

import java.util.List;

import com.ikubinfo.primefaces.model.Sustenance;

public interface ViewMenuService {
	List<Sustenance> getBeverages();
	List<Sustenance> getStarters();
	List<Sustenance> getSoupChilliSalads();
	List<Sustenance> getBurgers();
	List<Sustenance> getDesserts();
	List<Sustenance> getSubstitutionSides();
	
}
