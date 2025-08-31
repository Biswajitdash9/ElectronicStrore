package com.product.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.db.connect.DBConnect;

public class ViewProductDAO 
{

    ArrayList<ProductBean> al=new ArrayList<ProductBean>();
    
    public ArrayList<ProductBean> retrieveData()
    
    {
    	try {
    		Connection con=DBConnect.getCon();
    	PreparedStatement	pstmt=con.prepareStatement("select * from Product");
    	
    	ResultSet rs=pstmt.executeQuery();
    		
    	while(rs.next())
    	{
    		ProductBean pb=new ProductBean();
    		
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
