package com.kh.ready.user.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.kh.ready.user.domain.User;


// Spring Security에서 사용되는 유저 정보 - 일반 로그인과 소셜 로그인 관련 인터페이스를 상속하여 같이 사용
public class CustomUserDetails implements UserDetails, OAuth2User{
	
	// Ready 서비스에 사용할 User 콤포지션
	private User user;
	
	// 소셜로그인에서 필요한 attribute 콤포지션
	private Map<String, Object> attributes;
	
	// 일반 로그인시 생성자
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
	// 소셜 로그인시 생성자
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
				if(user.getUserRole()!= null) {
					return user.getUserRole().toString();
				}
				// 소셜 로그인시 일단은 권한 부여
				return "ROLE_USER";
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

