package com.kh.ready.user.security.oauth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.repository.UserRepository;
import com.kh.ready.user.security.CustomUserDetails;

@Component
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		// 소셜로그인 클릭시 작동하여 oauth2User 타입에 리턴 정보를 저장
		OAuth2User oauth2User = super.loadUser(userRequest);

		// 최상위 인터페이스 선언
		OAuth2UserInfo oAuth2UserInfo = null;
		
		// 정보 제공자마다 제공 key, value가 달라 제공자 기준으로 기초정보 자동 주입
		if(userRequest.getClientRegistration().getRegistrationId().equals("google")) {
			System.out.println("구글 로그인");
			oAuth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
		} else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
			System.out.println("네이버 로그인");
			oAuth2UserInfo = new NaverUserInfo((Map)oauth2User.getAttributes().get("response"));
		} else if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
			oAuth2UserInfo = new KakaoUserInfo((Map)oauth2User.getAttributes());
		} else {
			System.out.println("제공하지 않는 서비스입니다.");
			return new CustomUserDetails(null);
		}
		
		// 객체 리턴을 위한 초기 정보 세팅
		String provider = oAuth2UserInfo.getProvider();
		System.out.println(provider);
		String providerId = oAuth2UserInfo.getProviderId();
		String userId = provider + "_" + providerId;
		String userPassword = encoder.encode(providerId);
		String userName = oAuth2UserInfo.getName();
		String userEmail = oAuth2UserInfo.getEmail();
		
		//객체 생성전 이전에 가입한 적이 있는지 체크
		User user = userRepository.getUserById(userId) ;
		
		// 가입한적이 없을 경우 새롭게 회원 생성, 아닐경우 찾은 유저를 리턴
		if(user == null) {
			User oauthUser = new User(userId, userPassword, userName, userEmail);
			return new CustomUserDetails(oauthUser, oauth2User.getAttributes());
		}else{
			return new CustomUserDetails(user);
		}
		
		
	}
}
