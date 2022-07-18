package com.ezen.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService detailsService;
	
	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}

	public SecurityConfig(boolean disableDefaults) {
		
	}

}
