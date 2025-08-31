package com.product.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.connect.DBConnect;

public class AddProductDAO {
	
	 

	public int insertProductDetails(ProductBean pb) throws Exception 
	{
		int rowCount=0;
		try 
		{
			
			Connection con=DBConnect.getCon();
			
		PreparedStatement	pstmt=con.prepareStatement("insert into product values (?,?,?,?,?)");
			
		pstmt.setString(1,pb.getpCode() );
		
		pstmt.setString(3, pb.getpCompany());		
		pstmt.setString(2, pb.getpName());		
		pstmt.setString(4, pb.getpPrice());		
		pstmt.setString(5, pb.getpQtn());
		
		rowCount=pstmt.executeUpdate();
			
		}catch(Exception e) {
		//	e.printStackTrace();
			throw e;
		}
		
	
		
		return  rowCount;
	}
}
