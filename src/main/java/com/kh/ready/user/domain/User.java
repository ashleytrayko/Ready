package com.kh.ready.user.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class User implements Serializable{
	
	private long userIndex; //pk // 자동부여
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userPostcode;
	private String userAddress;
	private String userDetailAddress;
	private String userPhone;
	private String userNickname;
	private int userPurchase; // 자동부여
	private String userTier; // 자동부여
	private Date userEnrollDate; // 자동부여
	private int userReserves; // 자동부여
	private Date userBirthday;
	private int userAge;
	private String userRole; // 자동부여
	private String enabled; // 자동부여
	
	// 자동부여항목들은 추후에 테이블 따로 둘수도 있음
	
	public User() {}

	public User(long userIndex, String userId, String userPassword, String userName, String userEmail,
			String userPostcode, String userAddress, String userDetailAddress, String userPhone, String userNickname,
			int userPurchase, String userTier, Date userEnrollDate, int userReserves, Date userBirthday, int userAge,
			String userRole, String enabled) {
		super();
		this.userIndex = userIndex;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPostcode = userPostcode;
		this.userAddress = userAddress;
		this.userDetailAddress = userDetailAddress;
		this.userPhone = userPhone;
		this.userNickname = userNickname;
		this.userPurchase = userPurchase;
		this.userTier = userTier;
		this.userEnrollDate = userEnrollDate;
		this.userReserves = userReserves;
		this.userBirthday = userBirthday;
		this.userAge = userAge;
		this.userRole = userRole;
		this.enabled = enabled;
	}

	public long getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(long userIndex) {
		this.userIndex = userIndex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPostcode() {
		return userPostcode;
	}

	public void setUserPostcode(String userPostcode) {
		this.userPostcode = userPostcode;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserDetailAddress() {
		return userDetailAddress;
	}

	public void setUserDetailAddress(String userDetailAddress) {
		this.userDetailAddress = userDetailAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getUserPurchase() {
		return userPurchase;
	}

	public void setUserPurchase(int userPurchase) {
		this.userPurchase = userPurchase;
	}

	public String getUserTier() {
		return userTier;
	}

	public void setUserTier(String userTier) {
		this.userTier = userTier;
	}

	public Date getUserEnrollDate() {
		return userEnrollDate;
	}

	public void setUserEnrollDate(Date userEnrollDate) {
		this.userEnrollDate = userEnrollDate;
	}

	public int getUserReserves() {
		return userReserves;
	}

	public void setUserReserves(int userReserves) {
		this.userReserves = userReserves;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userIndex=" + userIndex + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userEmail=" + userEmail + ", userPostcode=" + userPostcode + ", userAddress="
				+ userAddress + ", userDetailAddress=" + userDetailAddress + ", userPhone=" + userPhone
				+ ", userNickname=" + userNickname + ", userPurchase=" + userPurchase + ", userTier=" + userTier
				+ ", userEnrollDate=" + userEnrollDate + ", userReserves=" + userReserves + ", userBirthday="
				+ userBirthday + ", userAge=" + userAge + ", userRole=" + userRole + ", enabled=" + enabled + "]";
	}
	
	
	
	
}
