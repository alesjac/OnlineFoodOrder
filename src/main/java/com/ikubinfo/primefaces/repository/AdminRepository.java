package com.ikubinfo.primefaces.repository;

import java.util.List;

import com.ikubinfo.primefaces.model.Admin;
import com.ikubinfo.primefaces.model.Sustenance;

public interface AdminRepository {
	boolean usernameExists(String username);
	boolean passwordExists(String password);
	List<Admin> getAdminByUsername(String username);
	boolean addBeverages(Sustenance sustenance);
	boolean addStarters(Sustenance susten);
}
