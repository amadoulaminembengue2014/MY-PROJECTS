package com.vlm.cityhall.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/signup","/user/login", "/person/**", "/mother/**", "/father/**", "/woman/**", "/send_mail")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and().exceptionHandling()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	

}
