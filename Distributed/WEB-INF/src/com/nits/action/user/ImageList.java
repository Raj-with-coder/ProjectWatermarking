/**
 * 
 */
package com.nits.action.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nits.DAOFactory.CommonDAO;
import com.nits.DAOFactory.DAO;
import com.nits.DAOFactory.DAOFactory;

public class ImageList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String submit=request.getParameter("submit");
			String id=request.getParameter("id");
			CommonDAO dao=CommonDAO.getInstance();
			ResultSet rs=dao.getSecretImages(id);
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/User/images.jsp?id="+id);
				rd.forward(request, response);
			}
			if(submit.equals("Add"))
			{
				rs=dao.getSecretImages(id);
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/User/images.jsp?no=4&id="+id);
				rd.forward(request, response);
			}
			if(submit.equals("Allocate"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null || chk.length!=1)
				{
					rs=dao.getSecretImages(id);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/images.jsp?no=5");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs=dao.getSecretImages(id);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/images.jsp?no=2&id="+id);
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						File f=new File(getServletContext().getRealPath("/")+"/Resources/Images/Secret_Images/"+dao.getSecretImageName(chk[i]));
						dao.deleteSecretImage(chk[i]);
						f.delete();
					}
					rs=dao.getSecretImages(id);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/images.jsp?no=3&id="+id);
					rd.forward(request,response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User UserList ImageList......"+e);
			out.println("Opps's Error is in User UserList ImageList......"+e);
		}
	}
}
