package com.kh.ready.user.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.kh.ready.user.domain.User;



public class CustomUserDetails implements UserDetails, OAuth2User{
	

	private User user;
	
	private Map<String, Object> attributes;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
	public CustomUserDetails(User user, Map<String, Object> attributes) {
		this.user = user; 
		this.attributes = attributes;
	}

	@Override
	public String getPassword() {
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserId();
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
		collection.add(new GrantedAuthority(){
			@Override
			public String getAuthority() {
				return user.getUserRole();
			}
		});
		
	return collection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}


	@Override
	public String getName() {
		return (String) attributes.get("name");
	}
	
	
}

