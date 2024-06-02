package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.authenticationHandler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class authenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(t -> t.getAuthority().equals("ADMIN"));
		if(isAdmin) {
			setDefaultTargetUrl("/clubs2");
		}
		else {
			setDefaultTargetUrl("/clubs2");
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
