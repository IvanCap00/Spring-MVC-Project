package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.authenticationHandler.authenticationHandler;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.UserentityDetailService;

@Configuration
@EnableWebSecurity
public class Securityconfig {
	
	
	public Securityconfig(UserentityDetailService userentityDetailService) {
		super();
		this.userentityDetailService = userentityDetailService;
	}


	private UserentityDetailService userentityDetailService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception{
		return httpsecurity
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(registry ->{ 
			registry.requestMatchers("/clubs/new","/clubs/{clubId}/delete","/clubs/{Id}/edit",
					"/events/{clubid}/new","/clubs/{eventId}/deleteEvent","/event/{Id}/{clubId}/edit").hasRole("USER");
			registry.requestMatchers("/user-list").hasRole("ADMIN");
			registry.anyRequest().permitAll();
		
				})
				.userDetailsService(userentityDetailService)
				.formLogin(formLogin -> formLogin.defaultSuccessUrl("/clubs2"))
					
				
				
				.build();

	}
	
	
	
	@Bean
	public UserentityDetailService userdetailservice() {
		return userentityDetailService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userentityDetailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
