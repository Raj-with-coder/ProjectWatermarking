/**
 * 
 */
package com.nits.DAOFactory;

/**
 * @author Nitin Gudle
 *Apr 7, 2012 4:05:43 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.nitin.DAOFactory
 *File:-DAOFactory.java
 */
public class DAOFactory
{
	public DAO getInstance(String name)
	{
		if(name.equals("Admin"))
			return new Admin();
		if(name.equals("User"))
			return new User();
		else
			return null;
	}
}
