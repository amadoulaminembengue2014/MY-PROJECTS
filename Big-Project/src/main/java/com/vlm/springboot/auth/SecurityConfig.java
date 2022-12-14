/*
 * package com.vlm.springboot.auth;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception{
 * http.cors(); http.csrf() .disable() .authorizeRequests()
 * .antMatchers(HttpMethod.OPTIONS,"/**") .permitAll() .anyRequest()
 * .authenticated() .and() .httpBasic();
 * 
 * }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception{ auth.inMemoryAuthentication() .withUser("mbengue@gmail.com")
 * .password("{noop}nkd250314").roles("USER"); }
 * 
 * }
 */