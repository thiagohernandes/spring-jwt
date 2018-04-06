package com.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.br.domain.User;
import com.br.jwt.JWTAuthenticationFilter;
import com.br.jwt.JWTLoginFilter;
import com.br.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/api/pages").permitAll()
			.antMatchers(HttpMethod.POST, "/api/login").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
			
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		for(User u : userService.allUsersList()) {
			auth.inMemoryAuthentication()
			.withUser(u.getName())
			.password(u.getPassword())
			.roles("ADMIN");
		}
	}
}