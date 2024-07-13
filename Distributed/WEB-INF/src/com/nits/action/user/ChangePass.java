/**
 * 
 */
package com.nits.action.user;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nits.DAOFactory.DAO;
import com.nits.DAOFactory.DAOFactory;

public class ChangePass extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			if(no==1)
			{
				String name=request.getParameter("name");
				request.setAttribute("user",name);
				RequestDispatcher rd=request.getRequestDispatcher("/Resources/JSP/User/changepass.jsp?no=0");
				rd.forward(request, response);
			}
			if(no==2)
			{
				int id=Integer.parseInt(request.getParameter("id"));
				String pass=request.getParameter("pass");
				String npass=request.getParameter("npass");
				String cpass=request.getParameter("cpass");
				String user=request.getParameter("user");
				request.setAttribute("user", user);
				DAOFactory factory=new DAOFactory();
				DAO dao=factory.getInstance("User");
				boolean result=dao.loginCHK(user, pass);
				if(result)
				{
					if(npass.equals(cpass))
					{
						result=dao.chnagePass(id, cpass);
						if(result)
						{
							ResultSet rs=dao.getProfile(user);
							request.setAttribute("rs",rs);
							RequestDispatcher rd=request.getRequestDispatcher("/Resources/JSP/User/profile.jsp?no=0&no1=1");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/Resources/JSP/User/changepass.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/Resources/JSP/User/changepass.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/Resources/JSP/User/changepass.jsp?no=1");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User ChangePass Servlet......"+e);
			out.println("Opps's Error is in User ChangePass Servlet......"+e);
		}
	}
}

