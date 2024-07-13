/**
 * 
 */
package com.nits.action.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.nits.DAOFactory.CommonDAO;
import com.nits.util.Utility;

public class AddImage extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String fileName="",root="",ext="";
			String newFileName = "";
			RequestDispatcher rd=null;
			File uploadedFile = null;
			File uploadedFile2 = null;
			boolean result=false;
			ResultSet rs=null;
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
	                    	if(fileName!="")
	                    		ext=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));
	                    	if(ext.equalsIgnoreCase("JPG")||ext.equalsIgnoreCase("BMP"))
	                    	{
	                    		//Utility.convertFormat(inputImagePath, outputImagePath, formatName)
	                    		root = getServletContext().getRealPath("/");
	                    		uploadedFile = new File(root+"/Resources/Images/Input_Images/"+fileName);
	                    		item.write(uploadedFile);
	                    		result=true;
	                    	}
	                    }
	                }
	                
	                /*String fileNameWithOutExt = FilenameUtils.removeExtension(fileName);
	                System.out.println("file name without extention : "+fileNameWithOutExt);
	                
	                FileInputStream inputStream = new FileInputStream(getServletContext().getRealPath("/")+"/Resources/Images/Input_Images2/"+fileName);
	                FileOutputStream outputStream = new FileOutputStream(getServletContext().getRealPath("/")+"/Resources/Images/Input_Images/"+fileNameWithOutExt+".bmp");
	                
	                 
	                // reads input image from file
	                BufferedImage inputImage = ImageIO.read(inputStream);
	                 
	                // writes to the output image in specified format
	                boolean result2 = ImageIO.write(inputImage, "bmp", outputStream);
	                System.out.println("image conversion status : "+result2);
	                 
	                // needs to close the streams
	                outputStream.close();
	                inputStream.close();
	                */
	                
	                
	                
	                
	                /*String formatName ="bmp";
	                uploadedFile2 = new File(root+"/Resources/Images/Input_Images/"+fileName);
	                Utility.convertFormat(uploadedFile, uploadedFile2, formatName);*/
	                
	                
	                
	                if(result)
	                {
	                	dao.addImage(fileName);
	                	rs=dao.getImages();
	                	request.setAttribute("rs", rs);
	    				rd=request.getRequestDispatcher("/Resources/JSP/Admin/images.jsp?no=1");
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
	            	System.out.println("Opps's Error is in Admin isMultipart Servlet......"+e);
	    			out.println("Opps's Error is in Admin Servlet isMultipart......"+e);
	            }
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin AddImage Servlet......"+e);
			out.println("Opps's Error is in Admin AddImage Servlet......"+e);
		}
	}
}
