package com.ikubinfo.primefaces.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.repository.AdminRepository;
import com.ikubinfo.primefaces.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRep;

	public AdminServiceImpl(AdminRepository adminRep) {
		this.adminRep = adminRep;
	}

	@Override
	public List<Admin> getAdminByUsername(String username) {
		return adminRep.getAdminByUsername(username);
	}

	@Override
	public boolean adminLogin(String username, String password) {
		boolean usernm = adminRep.usernameExists(username);
		boolean pass = adminRep.passwordExists(password);

		if (usernm == true && pass == true) {
			return true;
		} else {
			return false;
		}

	}

}
