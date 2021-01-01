package com.ikubinfo.primefaces.service;

import java.util.List;

import com.ikubinfo.primefaces.model.Admin;

public interface LoginAdminService {
List<Admin> getAdmin(String username,String password);
List<Admin> getAdminByUsername(String username);
}
