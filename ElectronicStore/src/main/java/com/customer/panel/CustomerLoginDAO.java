package com.customer.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.connect.DBConnect;

public class CustomerLoginDAO 
{
	public CustomerBean checkValidCustomer( String uname,String pword)
	{
		CustomerBean cb=null;
		try {
			
			Connection con=DBConnect.getCon();
   PreparedStatement pstmt=con.prepareStatement("select * from customer where uname=? and pword=?");
			
	pstmt.setString(1, uname);
	pstmt.setString(2, pword);
	ResultSet rs=pstmt.executeQuery();
	
	if(rs.next())
	{
		cb=new CustomerBean();
		cb.setUserName(rs.getString(1));
		cb.setPassword(rs.getString(2));
		cb.setFirstName(rs.getString(3));
		cb.setLastName(rs.getString(4));
		cb.setAddress(rs.getString(5));
		cb.setMail(rs.getString(6));
		cb.setMobile(rs.getString(7));
		
	}
	
   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 return cb;
	}

}
