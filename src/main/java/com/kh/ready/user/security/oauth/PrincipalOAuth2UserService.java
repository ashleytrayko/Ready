package com.kh.ready.user.security.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("getClientRegistration : "+userRequest.getClientRegistration()); // registrationId로 어떤 OAuth로 로그인 했는지 확인가능.
		System.out.println("getAccessToken : "+userRequest.getAccessToken().getTokenValue());
		// 구글로그인 버튼 클릭 -> 구글로그인창 -> 로그인완료 -> code를 리턴(OAuth-Client라이브러리) -> AccessToken 요청
		// userRequest 정보 -> loadUser함수 -> 회원프로필 받아야함
		System.out.println("getAttributes : " + super.loadUser(userRequest).getAttributes());
		OAuth2User oauth2User = super.loadUser(userRequest);
		return super.loadUser(userRequest);
	}
}
