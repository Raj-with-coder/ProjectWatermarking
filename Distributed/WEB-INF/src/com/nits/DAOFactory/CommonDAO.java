/**
 * 
 */
package com.nits.DAOFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nits.database.Database;
import com.nits.util.Utility;

public class CommonDAO 
{
	private static CommonDAO dao=null;
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private CommonDAO(){}
	public static CommonDAO getInstance()
	{
		if(dao==null)
			return new CommonDAO();
		else
			return dao;
	}
	public ResultSet getImages() 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_image");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImages()....."+e);
		}
		return resultSet;
	}
	public ResultSet getInbox(String id) 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_trans where to_id='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImages()....."+e);
		}
		return resultSet;
	}
	public ResultSet getSecretImages(String id) 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_secret where img_user='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImages()....."+e);
		}
		return resultSet;
	}
	public boolean addImage(String img_name) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into m_image (img_name) values('"+img_name+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin add image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-addImage()....."+e);
		}
		return flag;
	}
	public boolean addSecretImage(String img_name,String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into m_secret (img_name,img_user) values('"+img_name+"','"+id+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin add image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-addImage()....."+e);
		}
		return flag;
	}
	
	public boolean deleteImage(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from m_image where img_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-deleteImage()....."+e);
		}
		return flag;
	}
	public boolean deleteSecretImage(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from m_secret where img_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User delete image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-deleteSecretImage()....."+e);
		}
		return flag;
	}
	public boolean deleteMessageImage(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from m_trans where trans_id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User delete image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-deleteMessageImage()....."+e);
		}
		return flag;
	}
	public String getImages(String chk) 
	{
		String id="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select img_user from m_image where img_id='"+chk+"'");
			if(resultSet.next())
			{
				id=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImages()....."+e);
		}
		return id;
	}
	public boolean allocateImage(String img_id,String user_id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_image set img_user='"+user_id+"' where img_id='"+img_id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin allocate image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-allocateImage()....."+e);
		}
		return flag;
	}
	public String getImageName(String chk) 
	{
		String name="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select img_name from m_image where img_id='"+chk+"'");
			if(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImageName()....."+e);
		}
		return name;
	}
	public ResultSet getImageName(String chk,String id) 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select img_name from m_image where img_id='"+chk+"' or img_user='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImageName()....."+e);
		}
		return resultSet;
	}
	public String getSecretImageName(String chk) 
	{
		String name="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select img_name from m_secret where img_id='"+chk+"'");
			if(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImageName()....."+e);
		}
		return name;
	}
	public String getMessageImageName(String chk) 
	{
		String name="";
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select img_name from m_trans where trans_id='"+chk+"'");
			if(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getMessageImageName()....."+e);
		}
		return name;
	}
	public ResultSet getSecretImageName(String chk,String id) 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select img_name from m_secret where img_id='"+chk+"' or img_user='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-getImageName()....."+e);
		}
		return resultSet;
	}
	public boolean makeTrans(String from,String to,String img,String sub) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into m_trans (from_id,to_id,img_name,img_sub,date,time,day) values('"+from+"','"+to+"','"+img+"','"+sub+"','"+Utility.getDate()+"','"+Utility.getTime()+"','"+Utility.getDay()+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User makeTrans : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CommonDAO-makeTrans()....."+e);
		}
		return flag;
	}
}
