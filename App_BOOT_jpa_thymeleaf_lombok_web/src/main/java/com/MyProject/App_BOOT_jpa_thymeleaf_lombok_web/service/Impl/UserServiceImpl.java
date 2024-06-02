package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Userentity;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository.UserEntityRepository;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private UserEntityRepository userEntityrepsoitory;

	
	@Autowired
	public UserServiceImpl(UserEntityRepository userEntityrepsoitory) {
		super();
		this.userEntityrepsoitory = userEntityrepsoitory;
	}



	@Override
	public List<Userentity> findAll() {
		List<Userentity> all = userEntityrepsoitory.findAll();
		return all;
	}



	@Override
	public void deleteUser(long id) {
		userEntityrepsoitory.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}
