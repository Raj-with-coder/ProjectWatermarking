/**
 * 
 */
package com.nits.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nits.DAOFactory.CommonDAO;

public class AllocateImage extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String id=request.getParameter("id");
			String img_id=request.getParameter("img_id");
			RequestDispatcher rd=null;
			CommonDAO dao=CommonDAO.getInstance();
			ResultSet rs=null;
			if(!id.equalsIgnoreCase(""))
			{
				dao.allocateImage(img_id, id);
				rs=dao.getImages();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=8");
				rd.forward(request, response);
			}
			else
			{
				rs=dao.getImages();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=-1");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin UserList ImageList......"+e);
			out.println("Opps's Error is in Admin UserList ImageList......"+e);
		}
	}
}