/**
 * 
 */
package com.nits.action.admin;

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
			CommonDAO dao=CommonDAO.getInstance();
			ResultSet rs=dao.getImages();
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp");
				rd.forward(request, response);
			}
			if(submit.equals("Add"))
			{
				rs=dao.getImages();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=4");
				rd.forward(request, response);
			}
			if(submit.equals("Allocate"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null || chk.length!=1)
				{
					rs=dao.getImages();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=5");
					rd.forward(request,response);
				}
				String id=dao.getImages(chk[0]);
				if(id==null)
				{
					rs=dao.getImages();
					DAOFactory factory=new DAOFactory();
					DAO dao1=factory.getInstance("Admin");
					ResultSet rs1=dao1.getUsers();
					request.setAttribute("rs", rs);
					request.setAttribute("rs1", rs1);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=7&img_id="+chk[0]);
					rd.forward(request,response);
				}
				else
				{
					rs=dao.getImages();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=6");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs=dao.getImages();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						dao.deleteImage(chk[i]);
//						File f=new File(getServletContext().getRealPath("/")+"/Resources/Images/Input_Images/"+dao.getImageName(chk[i]));
//						System.out.println("----------------------------------------->:"+f);
//						f.delete();
					}
					rs=dao.getImages();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=3");
					rd.forward(request,response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin UserList ImageList......"+e);
			out.println("Opps's Error is in Admin UserList ImageList......"+e);
		}
	}
}
