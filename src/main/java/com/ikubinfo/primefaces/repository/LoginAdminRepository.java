package com.ikubinfo.primefaces.repository;

import java.util.List;

import com.ikubinfo.primefaces.model.Admin;

public interface LoginAdminRepository {
List<Admin> getAdmin(String username,String password);
List<Admin> getAdminByUsername(String username);
}
