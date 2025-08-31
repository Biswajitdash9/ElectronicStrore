package com.customer.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.connect.DBConnect;
import com.product.panel.ProductBean;

public class BuyProductDAO 
{
	 public ProductBean showData(String pcode)
	 {
		 ProductBean pb=new ProductBean();
		 try {
			 Connection con=DBConnect.getCon();
			 
			PreparedStatement pstmt=con.prepareStatement("select * from product where pcode=?");
			
			pstmt.setString(1,pcode);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				pb.setpCode(rs.getString(1));
				pb.setpName(rs.getString(2));
				pb.setpCompany(rs.getString(3));
				pb.setpPrice(rs.getString(4));
				pb.setpQtn(rs.getString(5));
				
				
			}
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 return pb;
	 }

}
