package com.customer.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.db.connect.DBConnect;
import com.product.panel.ProductBean;

public class ViewCustomerProductDAO 
{
	ArrayList<ProductBean> al=new ArrayList<ProductBean>();
	
   public ArrayList<ProductBean> viewData()
   {
	   try 
	   {
		   Connection con= DBConnect.getCon();
		   PreparedStatement pstmt=con.prepareStatement("select * from product");
		   ResultSet rs=pstmt.executeQuery();
		   
		   while(rs.next())
		   {
			 ProductBean pb =new ProductBean();
			 
			 pb.setpCode(rs.getString(1));
			 pb.setpName(rs.getString(2));
			 pb.setpCompany(rs.getString(3));
			 pb.setpPrice(rs.getString(4));
			 pb.setpQtn(rs.getString(5));
			 al.add(pb);
			      
		   }
		   
	   }
	   catch(Exception e)
	   {
	    e.printStackTrace();
       }

	   return al;
}
   }
