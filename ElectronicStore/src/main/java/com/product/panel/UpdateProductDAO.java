package com.product.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.connect.DBConnect;

public class UpdateProductDAO 
{

	public int updateData(ProductBean pb )
	{
		int rowcount=0;
		try {
			
			Connection con=DBConnect.getCon();
			
		PreparedStatement	pstmt=con.prepareStatement("update product set pprice=? ,pqty=? where pcode=?");
			
		pstmt.setString(1,pb.getpPrice());
		pstmt.setString(2, pb.getpQtn());
		
		pstmt.setString(3,pb.getpCode());
		
	rowcount=pstmt.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowcount;
	}
}
