package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Club;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository.ClubRepository;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.ClubService;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.UserentityDetailService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication

public class AppBootJpaThymeleafLombokWebApplication {
	
	private ClubService clubservice;
	
	// se scrivi @autowired ti inietta il costruttore
	
	
	private UserentityDetailService userentitydetailservice;
	
	/*
	public AppBootJpaThymeleafLombokWebApplication(UserEntityDetailService usernetitydetailservice) {
		super();
		this.usernetitydetailservice = usernetitydetailservice;
	}
	*/

	

	public static void main(String[] args) {
		SpringApplication.run(AppBootJpaThymeleafLombokWebApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(ClubService clubservice ) {
		return (args ->{
			System.out.println(clubservice.findallClubs());
			
			
		});
	}
	
	



}
