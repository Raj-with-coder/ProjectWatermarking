/**
 * 
 */
package com.nits.action.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nits.DAOFactory.CommonDAO;

public class AddImage extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String fileName="",root="",ext="",id="";
			RequestDispatcher rd=null;
			File uploadedFile = null;
			boolean result=false;
			ResultSet rs=null;
			Random random=new Random();
			int num=0;
			CommonDAO dao=CommonDAO.getInstance();
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            try
	            {
	            	List items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) 
	                {
	                	FileItem item = (FileItem) iterator.next();
	                    if (!item.isFormField()) 
	                    {
	                    	fileName = item.getName();
	                    	num = random.nextInt(12345) + 1;
	                    	root = getServletContext().getRealPath("/");
	                    	uploadedFile = new File(root+"/Resources/Images/Secret_Images/"+num+fileName);
	                    	item.write(uploadedFile);
	                    	result=true;
	                    }
	                    else
	                    	id=item.getString();
	                }
	                if(result)
	                {
	                	dao.addSecretImage(num+fileName,id);
	                	rs=dao.getSecretImages(id);
	                	request.setAttribute("rs", rs);
	    				rd=request.getRequestDispatcher("/Resources/JSP/User/images.jsp?no=1");
	    				rd.forward(request, response);
	                }
	                else
	                {
	                	rs=dao.getSecretImages(id);
	                	request.setAttribute("rs", rs);
	    				rd=request.getRequestDispatcher("/Resources/JSP/User/images.jsp?no=-1");
	    				rd.forward(request, response);
	                }
	            }
	            catch(Exception e)
	            {
	            	System.out.println("Opps's Error is in User isMultipart Servlet......"+e);
	    			out.println("Opps's Error is in User Servlet isMultipart......"+e);
	            }
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User AddImage Servlet......"+e);
			out.println("Opps's Error is in User AddImage Servlet......"+e);
		}
	}
}
