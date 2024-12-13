package com.comCast.crm.generic.dataBaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class DataBaseUtility 
{
	Connection con;
	public void getConnection(String url, String username,String password ) throws Exception
  {
		try 
  {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 con=DriverManager.getConnection(url,username,password);
			
  }
	catch(Exception e)
		{
		
		}
		
	
  }
	public void getConnection() throws Exception
	  {
			try 
	  {
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				Connection con=DriverManager.getConnection("jdbc://localhost:3306/projects","root","root");
				
	  }
		catch(Exception e)
			{
			
			}
			
		
	  }
	
	public void CloseDbConnection() throws Exception
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
		
		}
		
	}

	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet result =null;
		try 
		{
			Statement stament = con.createStatement(); 
			 result = stament.executeQuery(query);
			
		}
		catch(Exception e)
		{
		
		}
		return result;
		
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try
		{
			Statement stament = con.createStatement(); 
			result=stament.executeUpdate(query);
		}
		catch(Exception e)
		{
		
		}
		return result;
	}

 
}
