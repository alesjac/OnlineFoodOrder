package com.ikubinfo.primefaces.service.impl;

import java.util.List;

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
public List<Admin> getAdmin(String username,String password) {
	
	return loginAdminRep.getAdmin(username,password);
}

@Override
public List<Admin> getAdminByUsername(String username) {
	return loginAdminRep.getAdminByUsername(username);
}




}
