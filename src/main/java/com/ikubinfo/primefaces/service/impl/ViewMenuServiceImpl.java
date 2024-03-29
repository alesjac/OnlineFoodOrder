package com.ikubinfo.primefaces.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.Sustenance;
import com.ikubinfo.primefaces.repository.ViewMenuRepository;
import com.ikubinfo.primefaces.service.ViewMenuService;

@Service("viewmenuService")
public class ViewMenuServiceImpl implements ViewMenuService {
	private ViewMenuRepository viewMenuRepository;
	

	public ViewMenuServiceImpl(ViewMenuRepository viewmenuRepository) {
		this.viewMenuRepository = viewmenuRepository;
		
	}

	@Override
	public List<Sustenance> getBeverages() {
		
		return viewMenuRepository.getBeverages();
	}

	@Override
	public List<Sustenance> getStarters() {
		
		return viewMenuRepository.getStarters();
		}

	@Override
	public List<Sustenance> getSoupChilliSalads() {
		return viewMenuRepository.getSoupChilliSalads();
	}

	@Override
	public List<Sustenance> getBurgers() {
		
		return viewMenuRepository.getBurgers();
	}

	@Override
	public List<Sustenance> getDesserts() {
		return viewMenuRepository.getDesserts();
		}

	@Override
	public List<Sustenance> getSubstitutionSides() {
		return viewMenuRepository.getSubstitutionSides();
	}

	
}
