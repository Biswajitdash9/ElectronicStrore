package com.admin.panel;

import java.io.Serializable;

public class AdminBean  implements Serializable{
	
	private String adminUserName,adminPassword,adminFname,adminLname,adminAddr,adminMail,adminPhn;
	
	//constructor
	public AdminBean()
	{
		
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminFname() {
		return adminFname;
	}

	public void setAdminFname(String adminFname) {
		this.adminFname = adminFname;
	}

	public String getAdminLname() {
		return adminLname;
	}

	public void setAdminLname(String adminLname) {
		this.adminLname = adminLname;
	}

	public String getAdminAddr() {
		return adminAddr;
	}

	public void setAdminAddr(String adminAddr) {
		this.adminAddr = adminAddr;
	}

	public String getAdminMail() {
		return adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public String getAdminPhn() {
		return adminPhn;
	}

	public void setAdminPhn(String adminPhn) {
		this.adminPhn = adminPhn;
	}
	
	

}
