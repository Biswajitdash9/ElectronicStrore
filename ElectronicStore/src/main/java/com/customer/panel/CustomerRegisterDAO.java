package com.customer.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.connect.DBConnect;

public class CustomerRegisterDAO 
{
	
  public	int insertCustomerData(CustomerBean cbean) 
  {
	  int rowcount=0;
	try 
	{
		Connection con=DBConnect.getCon();
	PreparedStatement	pstmt=con.prepareStatement("Insert into customer values(?,?,?,?,?,?,?)");
		
	pstmt.setString(1,cbean.getUserName() );
	pstmt.setString(2, cbean.getPassword());
	pstmt.setString(3,cbean.getFirstName() );
	pstmt.setString(4,cbean.getLastName() );
	pstmt.setString(5,cbean.getAddress() );
	pstmt.setString(6,cbean.getMail() );
	pstmt.setString(7,cbean.getMobile() );
	
	 rowcount=pstmt.executeUpdate();
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	return rowcount;
}
}