package com.ikubinfo.primefaces.service.impl;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.Sustenance;

import com.ikubinfo.primefaces.repository.AdminPageRepository;

import com.ikubinfo.primefaces.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	private AdminPageRepository adminRep;

	public AdminServiceImpl(AdminPageRepository adminRep) {
	
		this.adminRep=adminRep;
	}
	
	@Override
	public boolean addBeverages(Sustenance bev) {
		
		return adminRep.addBeverages(bev);
	}

	@Override
	public boolean addStarters(Sustenance susten) {
		
		return adminRep.addStarters(susten);
	}


	

	@Override
	public boolean editSus(Sustenance sus) {
		
		return adminRep.editSustenance(sus);
	}

	

	

}
