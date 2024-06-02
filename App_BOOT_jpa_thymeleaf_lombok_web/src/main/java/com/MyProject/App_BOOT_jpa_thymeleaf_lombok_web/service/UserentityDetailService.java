package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Userentity;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository.UserEntityRepository;

@Service("userDetailsService")
public class UserentityDetailService implements UserDetailsService {
	
	@Autowired
	private UserEntityRepository userEntityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Userentity> byUsername = userEntityRepository.findByUsername(username);
		if(byUsername.isPresent()) {
			var obj = byUsername.get();
			return User.builder()
					.username(obj.getUsername())
					.password(obj.getPass_word())
					.roles(getRoles(obj))
					.build();
			
		} else {
			throw new UsernameNotFoundException(username);
		}
		
	}
	
	private String[] getRoles(Userentity user) {
		if (user.getRole()==null) {
			return new String[] {"USER"};
		} return user.getRole().split(",");
				
				
		
		
	}
	

}
