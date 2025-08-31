package com.db.connect;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
private DBConnect() {
		
	}
		
	
	private static Connection con=null;
	
	static {
		
		try {
			Class.forName(DBInfo.Driver);
			con =DriverManager.getConnection(DBInfo.Url,DBInfo.Usname, DBInfo.pwd);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	 static public Connection getCon()
	{
		return con;
	}

}
