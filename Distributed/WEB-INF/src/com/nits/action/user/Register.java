/**
 * 
 */
package com.nits.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nits.DAOFactory.DAO;
import com.nits.DAOFactory.DAOFactory;

public class Register extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String add = request.getParameter("add");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String cno = request.getParameter("cno");
			DAOFactory factory=new DAOFactory();
			DAO dao=factory.getInstance("User");
			boolean result=dao.CHK(id);
			if(!result)
			{
				result=dao.register(id, pass, name, gender, add, city, email, cno);
				if(result)
				{
					response.sendRedirect(request.getContextPath()+"?no=4");
				}
				else
					response.sendRedirect(request.getContextPath()+"?no=3");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"?no=2&no1=5");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Register Servlet......"+e);
			out.println("Opps's Error is in Register Servlet......"+e);
		}
	}
}
