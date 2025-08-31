package com.buyrecord.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.db.connect.DBConnect;

public class MyOrderDAO {
	
	public ArrayList<RecordBean> viewRecord(String uname)
	{
		ArrayList<RecordBean> al=new ArrayList<RecordBean>();
	
		try {
			
			Connection con=DBConnect.getCon();
		PreparedStatement	pstmt=con.prepareStatement("Select * from buyrecord where uname=?");
		pstmt.setString(1, uname);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			RecordBean rb=new RecordBean();
			rb.setOrderid(rs.getLong(1));
			rb.setUname(rs.getString(2));
			rb.setPcode(rs.getString(3));
			rb.setPname(rs.getString(4));
			rb.setPcompany(rs.getString(5));
			rb.setPrice(rs.getString(6));
			rb.setItemPurchased(rs.getString(7));
			rb.setTotal(rs.getString(8));
			rb.setDate(rs.getString(9));
			al.add(rb);
			
			
		}
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

}
