package com.kh.ready.user.domain;


public class Banner {
	private Integer bannerNumber;
	private String bannerName;
	private String bannerRename;
	private String bannerPath;
	
	public Banner(Integer bannerNumber, String bannerName, String bannerRename, String bannerPath) {
		super();
		this.bannerNumber = bannerNumber;
		this.bannerName = bannerName;
		this.bannerRename = bannerRename;
		this.bannerPath = bannerPath;
	}

	public Integer getBannerNumber() {
		return bannerNumber;
	}

	public void setBannerNumber(Integer bannerNumber) {
		this.bannerNumber = bannerNumber;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getBannerRename() {
		return bannerRename;
	}

	public void setBannerRename(String bannerRename) {
		this.bannerRename = bannerRename;
	}

	public String getBannerPath() {
		return bannerPath;
	}

	public void setBannerPath(String bannerPath) {
		this.bannerPath = bannerPath;
	}

	@Override
	public String toString() {
		return "Banner [bannerNumber=" + bannerNumber + ", bannerName=" + bannerName + ", bannerRename=" + bannerRename
				+ ", bannerPath=" + bannerPath + "]";
	}
	
	
}
