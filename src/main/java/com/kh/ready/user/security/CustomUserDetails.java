package com.kh.ready.user.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kh.ready.user.domain.User;

import lombok.Getter;


public class CustomUserDetails implements UserDetails{
	
	private String id;
	private String password;
	private String name;
	private String auth;
	private int enabled;
	
	private User user;
	
	public CustomUserDetails() {}
	
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
	public CustomUserDetails(String id, String password, String name, String auth, int enabled) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.auth = auth;
		this.enabled = enabled;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(()->{
			return auth;
		});
		
	return collection;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

