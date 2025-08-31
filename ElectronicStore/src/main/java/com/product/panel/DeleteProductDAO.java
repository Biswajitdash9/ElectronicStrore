package com.product.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.connect.DBConnect;

public class DeleteProductDAO {
 

	int rowcount;
	public int deleteProduct(String pcode) {
	try {
		Connection con=DBConnect.getCon();
	PreparedStatement	pstmt=con.prepareStatement("Delete from product where pcode=?");
	
	pstmt.setString(1, pcode);
		
	rowcount=pstmt.executeUpdate();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return rowcount;
	
}
}
