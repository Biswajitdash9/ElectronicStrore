package com.admin.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.connect.DBConnect;

public class AdminLoginDAO 
{

	public AdminBean checkAdminLogin(String aname,String apwd)
	{
		
		AdminBean abean=null;
		
		try {
			
			Connection con=DBConnect.getCon();
		 PreparedStatement	pstmt=con.prepareStatement("select * from admin where uname=? and pword=?");
		 
		 pstmt.setString(1,aname);
		 pstmt.setString(2,apwd);
		 
		 ResultSet rs=pstmt.executeQuery();
		 
		 if(rs.next()) {
			 abean=new AdminBean();
			 
			 abean.setAdminUserName(rs.getString(1));
			 abean.setAdminPassword(rs.getString(2));
             abean.setAdminFname(rs.getString(3));
             	abean.setAdminLname(rs.getString(4));
             	abean.setAdminMail(rs.getString(5));
             	abean.setAdminPhn(rs.getString(6));
		 
		 }
		}
		catch
		(Exception e)
		{
			e.printStackTrace();
		}
		 return abean;
	}
}

