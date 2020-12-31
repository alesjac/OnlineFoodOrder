package com.ikubinfo.primefaces.service.impl;

import org.springframework.stereotype.Service;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.repository.LoginAdminRepository;
import com.ikubinfo.primefaces.service.LoginAdminService;
@Service("loginAdminService")
public class LoginAdminServiceImpl implements LoginAdminService {

private LoginAdminRepository loginAdminRep;

public LoginAdminServiceImpl(LoginAdminRepository loginAdminRep) {
	this.loginAdminRep=loginAdminRep;
}

@Override
public Admin getAdmin() {
	
	return loginAdminRep.getAdmin();
}




}
