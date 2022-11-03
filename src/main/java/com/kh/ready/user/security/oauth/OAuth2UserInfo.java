package com.kh.ready.user.security.oauth;

// 소셜 로그인시 필요한 정보
public interface OAuth2UserInfo {
	String getProviderId();
	String getProvider();
	String getEmail();
	String getName();
}
