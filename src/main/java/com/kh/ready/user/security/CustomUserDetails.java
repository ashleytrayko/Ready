package com.kh.ready.user.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kh.ready.user.domain.User;

import lombok.Getter;


public class CustomUserDetails implements UserDetails{
	
//	private String id;
//	private String password;
//	private String name;
//	private String auth;
//	private String enabled;
//	
	private User user;
	
//	public CustomUserDetails() {}
	
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
//	public CustomUserDetails(String id, String password, String name, String auth, String enabled) {
//		super();
//		this.id = id;
//		this.password = password;
//		this.name = name;
//		this.auth = auth;
//		this.enabled = enabled;
//	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getId();
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
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(()->{
			return user.getAuth().toString();
		});
		
	return collection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

