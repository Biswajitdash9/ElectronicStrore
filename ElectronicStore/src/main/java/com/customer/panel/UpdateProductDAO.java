package com.customer.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.buyrecord.panel.RecordBean;
import com.db.connect.DBConnect;

public class UpdateProductDAO 
{
   public	int updateProduct(int set,String pcode,RecordBean rb)
   {
	   int rowcount=0;
	   try 
	   {
		   Connection con=DBConnect.getCon();
		 PreparedStatement pstmt= con.prepareStatement("update product set pqty="+set+" where pcode=?");
		 
		 
		 pstmt.setString(1,pcode );
		 rowcount=pstmt.executeUpdate();
		 
		PreparedStatement pstmt1=con.prepareStatement("insert into buyrecord values(buyseq.nextval,?,?,?,?,?,?,?,sysdate)");
		pstmt1.setString(1, rb.getUname());
		pstmt1.setString(2, rb.getPcode());
		pstmt1.setString(3, rb.getPname());
		pstmt1.setString(4, rb.getPcompany());
		pstmt1.setString(5, rb.getPrice());
		pstmt1.setString(6, rb.getItemPurchased());
		int price=Integer.parseInt(rb.getPrice());
		int purchased=Integer.parseInt(rb.getItemPurchased());
		long total=price*purchased;
        
		
		pstmt1.setLong(7, total);
		
		pstmt1.executeUpdate();
		
		
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return  rowcount;
   }

}
