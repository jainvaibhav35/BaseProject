package com.mail;

public class AppData {
	
	private int Id ;
	private String appName ;
	private String downloads;
	private String inApp ;
	private String email ;
	private String updated ;
	public AppData(int id, String appName, String downloads, String inApp,
			String email, String updated) {
		super();
		Id = id;
		this.appName = appName;
		this.downloads = downloads;
		this.inApp = inApp;
		this.email = email;
		this.updated = updated;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getDownloads() {
		return downloads;
	}
	public void setDownloads(String downloads) {
		this.downloads = downloads;
	}
	public String getInApp() {
		return inApp;
	}
	public void setInApp(String inApp) {
		this.inApp = inApp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	

}
