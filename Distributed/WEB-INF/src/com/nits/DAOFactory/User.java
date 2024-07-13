/**
 * 
 */
package com.nits.DAOFactory;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.nits.database.Database;

/**
 * @author Nitin Gudle
 *Apr 7, 2012 4:04:54 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.nitin.DAOFactory
 *File:-UserDAO.java
 */
public class User extends DAO
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
			resultSet = statement.executeQuery("select * from m_user where userid='"+name+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-loginCHK()....."+e);
		}
		return flag;
	}
	public boolean register(String id, String pass, String name, String gender,String add, String city, String email, String cno) 
	{
		boolean flag=false;
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("insert into m_user (userid,password,username,gender,address,city,email,phone) values('"+id+"','"+pass+"','"+name+"','"+gender+"','"+add+"','"+city+"','"+email+"','"+cno+"');");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Registeration Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-register()....."+e);
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
			System.out.println("Opp's Error is in UserDAO-CHK()....."+e);
		}
		return flag;
	}
	public ResultSet getProfile(String id)
	{
		try
		{
			Database database=Database.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where userid='"+id+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
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
			int i=statement.executeUpdate("update m_user set username='"+s[1]+"',gender='"+s[2]+"',address='"+s[3]+"',city='"+s[4]+"',email='"+s[5]+"',phone='"+s[6]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editProfile()....."+e);
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
			int i=statement.executeUpdate("update m_user set password='"+cpass+"' where id='"+id+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass()....."+e);
		}
		return flag;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#getUsers()
	 */
	@Override
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
			System.out.println("Opp's Error is in UserDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#deleteUser(java.lang.String)
	 */
	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#getUsers(java.lang.String)
	 */
	@Override
	public ResultSet getUsers(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#editUser(java.lang.String[])
	 */
	@Override
	public boolean editUser(String[] s) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#getAuditors()
	 */
	@Override
	public ResultSet getAuditors() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#CHKAuditor(java.lang.String)
	 */
	@Override
	public boolean CHKAuditor(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#addAuditor(java.lang.String[])
	 */
	@Override
	public boolean addAuditor(String[] s) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#deleteAuditor(java.lang.String)
	 */
	@Override
	public boolean deleteAuditor(String s) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#editAuditor(java.lang.String[])
	 */
	@Override
	public boolean editAuditor(String[] s) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.nitin.DAOFactory.DAO#getAuditors(java.lang.String)
	 */
	@Override
	public ResultSet getAuditors(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
