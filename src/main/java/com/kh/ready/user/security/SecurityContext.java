package com.kh.ready.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kh.ready.user.repository.UserRepository;
import com.kh.ready.user.security.oauth.PrincipalOAuth2UserService;
import com.kh.ready.user.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityContext extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private PrincipalOAuth2UserService principalOAuth2UserService;
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/","/resources/**","/common/**","/book/**").permitAll()
				.antMatchers("/user/**","/cart/**","/order/**").authenticated()
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
				.anyRequest().permitAll()
			.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("userId")
				.passwordParameter("userPassword")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
			.and()
				.logout()
				.logoutSuccessUrl("/")
			.and()
				.oauth2Login()
				.loginPage("/login")
				.defaultSuccessUrl("/moreInfo")
				.userInfoEndpoint()
				.userService(principalOAuth2UserService);
		
	}
}
