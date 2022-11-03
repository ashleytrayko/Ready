package com.kh.ready.user.security.oauth;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo{
	
	private Map<String, Object> attributes;
	
	public KakaoUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	@Override
	public String getProviderId() {
		return String.valueOf(attributes.get("id"));
	}

	@Override
	public String getProvider() {
		return "kakao";
	}

	@Override
	public String getEmail() {
		Map map1 = (Map) attributes.get("kakao_account");
		
		return (String) map1.get("email");
	}

	@Override
	public String getName() {
		Map map2 = (Map) attributes.get("properties");
		return (String) map2.get("nickname");
	}
}
