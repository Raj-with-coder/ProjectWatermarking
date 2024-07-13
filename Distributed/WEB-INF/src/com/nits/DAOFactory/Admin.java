/**
 * 
 */
package com.nits.DAOFactory;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.nits.database.Database;

public class Admin extends DAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where adminid='"+name+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	public boolean register(String id, String pass, String name, String gender,	String add, String city, String email, String cno) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into m_user (userid,password,username,gender,address,city,email,phone) values('"+id+"','"+pass+"','"+name+"','"+gender+"','"+add+"','"+city+"','"+email+"','"+cno+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Registeration Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-register()....."+e);
		}
		return flag;
	}
	public boolean CHK(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where userid='"+id+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-CHK()....."+e);
		}
		return flag;
	}
	public ResultSet getProfile(String name)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where adminid='"+name+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	public boolean editProfile(String [] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_admin set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile()....."+e);
		}
		return flag;
	}
	public boolean chnagePass(int id, String cpass) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_admin set password='"+cpass+"' where id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass()....."+e);
		}
		return flag;
	}
	public ResultSet getUsers() 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	public ResultSet getUsers(int a) 
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
			System.out.println("Opp's Error is in AdminDAO-getImages()....."+e);
		}
		return resultSet;
	}
	public boolean deleteUser(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from m_user where id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete user Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUser()....."+e);
		}
		return flag;
	}
	public ResultSet getUsers(String id)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where id='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	public boolean editUser(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_user set username='"+s[1]+"',address='"+s[2]+"',city='"+s[3]+"',email='"+s[4]+"',phone='"+s[5]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUser()....."+e);
		}
		return flag;
	}
	public ResultSet getAuditors() 
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from auditlogin");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getAuditors()....."+e);
		}
		return resultSet;
	}
	public boolean CHKAuditor(String id) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from auditlogin where auditid='"+id+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Audit Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-CHKAuditor()....."+e);
		}
		return flag;
	}
	public boolean addAuditor(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into auditlogin (name,password,auditid,address,phone,email) values('"+s[0]+"','"+s[1]+"','"+s[2]+"','"+s[3]+"','"+s[4]+"','"+s[5]+"')");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Add Auditor Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addAuditor()....."+e);
		}
		return flag;
	}
	public boolean deleteAuditor(String s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("delete from auditlogin where id='"+s+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin delete auditor Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteAuditor()....."+e);
		}
		return flag;
	}
	public boolean editAuditor(String[] s) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update auditlogin set name='"+s[1]+"',auditid='"+s[2]+"',address='"+s[3]+"',phone='"+s[4]+"',email='"+s[5]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Auditor Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editAuditor()....."+e);
		}
		return flag;
	}
	public ResultSet getAuditors(String id)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from auditlogin where id='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getAuditors()....."+e);
		}
		return resultSet;
	}
}
