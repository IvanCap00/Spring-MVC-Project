package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service;

import java.util.List;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Userentity;

public interface UserService {
	
	List<Userentity> findAll();
	
	void deleteUser(long id);
}
