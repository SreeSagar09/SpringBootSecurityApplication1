package com.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean 
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
		.inMemoryAuthentication()
		.withUser("sample@mail.com")
		.password(passwordEncoder().encode("sample@123456"))
		.roles("USER")
		.and()
		.withUser("test@mail.com")
		.password(passwordEncoder().encode("test@123456"))
		.roles("USER", "ADMIN");
	}

}
