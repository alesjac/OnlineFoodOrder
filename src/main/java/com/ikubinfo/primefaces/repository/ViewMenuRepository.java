package com.ikubinfo.primefaces.repository;

import java.util.List;

import com.ikubinfo.primefaces.model.Sustenance;

public interface ViewMenuRepository {
	List<Sustenance> getBeverages();
	List<Sustenance> getStarters();
	List<Sustenance> getSoupChilliSalads();
	List<Sustenance> getBurgers();
	List<Sustenance> getDesserts();
	List<Sustenance> getSubstitutionSides();
}
