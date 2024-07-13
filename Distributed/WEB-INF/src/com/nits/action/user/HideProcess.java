
package com.nits.action.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nits.DAOFactory.CommonDAO;
import com.nits.DAOFactory.DAO;
import com.nits.DAOFactory.DAOFactory;
import com.nits.util.AES_File_EncNdec;
import com.nits.util.MD5;
import com.nits.util.Utility;

public class HideProcess extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		try
		{
			String select1=request.getParameter("select1");
			String select2=request.getParameter("select2");
			String select3=request.getParameter("select3");
			String sub=request.getParameter("sub");
			String id=request.getParameter("name");
			CommonDAO dao=CommonDAO.getInstance();
			ResultSet rs=dao.getInbox(id);
			RequestDispatcher rd=null;
			String main_img = select1.substring(select1.lastIndexOf("/")+1,select1.lastIndexOf(""));
			String secret_img=select2.substring(select2.lastIndexOf("/")+1,select2.lastIndexOf(""));
			System.out.println(main_img+"--------++++++++++++++++++++++secret image is: "+secret_img);
			String sec_Img=request.getRealPath("")+"/Resources/Images/Secret_Images/"+secret_img;
			
			String main_Img = request.getRealPath("")+"/Resources/Images/Input_Images/"+main_img;
			
			//String sec_Img =getServletContext().getRealPath("/")+"/Resources/Images/Secret_Images/Sec_Img.bmp";
			String enc_Sec_ImgPath =request.getRealPath("")+"/Resources/Images/Enc_Sec_Img/Sec_Img.png";
			
			
			String password="password12345678";
			
			AES_File_EncNdec.encryptFile(sec_Img, enc_Sec_ImgPath, password);
			
			
			
			
			String stegnoImage1Path =request.getRealPath("")+"/Resources/Temp/stegnoImage1.png";
			String stegnoImage2Path =request.getRealPath("")+"/Resources/Temp/stegnoImage2.png";
			String stegnoImage3Path =request.getRealPath("")+"/Resources/Temp/stegnoImage3.png";
			String stegnoImage4Path =request.getRealPath("")+"/Resources/Temp/stegnoImage4.png";
			
			
			
			Random random=new Random();
			int num = random.nextInt(100000);
			String stegnoImage5Path =request.getRealPath("")+"/Resources/Temp2/stegnoImage5.png";
			String stegnoImage6Path =request.getRealPath("")+"/Resources/Temp2/stegnoImage6.png";
			String stegnoImage7Path =request.getRealPath("")+"/Resources/Temp2/stegnoImage7.png";
			String stegnoImage8Path =request.getRealPath("")+"/Resources/Images/Messages/"+num+"stegnoImage8.png";
			
			
			   
			if(main_img.equalsIgnoreCase("main.jpg") || secret_img.equalsIgnoreCase("secret.jpg") || select3.equalsIgnoreCase("No_User"))
			{
				
				ResultSet rs1=dao.getImageName("", id);
				ResultSet rs2=dao.getSecretImageName("", id);
				DAOFactory factory=new DAOFactory();
				DAO dao1=factory.getInstance("User");
				ResultSet rs3=dao1.getUsers();
				request.setAttribute("rs", rs);
				request.setAttribute("name", id);
				request.setAttribute("rs1", rs1);
				request.setAttribute("rs2", rs2);
				request.setAttribute("rs3", rs3);
				rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=6&no1=101");
				rd.forward(request, response);
			}
			else
			{
				File main = new File(request.getRealPath("")+"/Resources/Images/Input_Images/"+main_img);
				
				File secret = new File(request.getRealPath("")+"/Resources/Images/Enc_Sec_Img/Sec_Img.png");
				
				if(main.length()>(secret.length()*10))
				{
					if ( session.getAttribute( "waitPage" ) == null ) 
				    {  
				    	   session.setAttribute( "waitPage", Boolean.TRUE );  
				    	   PrintWriter outter = response.getWriter();  
				    	   outter.println( "<html><head>" );  
				    	   outter.println( "<title>Please Wait...</title>" );  
				       	   outter.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
				    	   outter.println( "</head><body background='Rrsources/Images/refresh2.jpg'>" );  
				    	   outter.println( "<br>" );
				    	   outter.println( "<center>" );
				    	   outter.print("<font color='red'>");
				    	   outter.println( "Please Do not press Back or Refresh button.......<br>  " );
				    	   outter.println("</font>");
				    	   outter.print("<font color='#fedcba'>");
				    	   outter.println( "Please,Wait..........<br>  " );
				    	   outter.println( "Image Hiding In Process..." );
				    	   outter.println( "<br>" );
				    	   outter.println("</font>");
				    	   outter.println( "<br>" );
				    	   outter.print( "<img src='Resources/Images/ajax_loader.gif'></img><br><br>");
				    	   outter.print("<font color='#AD814E'>");
				    	   outter.println( "Please Do not press Back or Refresh button.......<br>  " );
				    	   outter.println( "<br>" );
				    	   outter.println( "Image Hiding is in process..." );
				    	   outter.println( "<br>" );
				    	   outter.println( "Hiding Logo Image Inside Main Image...." );
				    	   outter.println("</font>");
				    	   outter.println( "<br>" );
				    	   outter.println( "Please wait....</h1></center");  
				    	   outter.close();  
				     }
					else
					{
						session.removeAttribute( "waitPage" );  
				    	
						response.setContentType("text/html");
				
					
					
					
					int zoneOneRandomNumber = DataHiding.getRandomNumber();
					int zoneTwoRandomNumber = DataHiding.getRandomNumber();
					int zoneThreeRandomNumber = DataHiding.getRandomNumber();
					int zoneFourRandomNumber = DataHiding.getRandomNumber();
					System.out.println("Zone-1 Random number is : "+zoneOneRandomNumber);
					System.out.println("Zone-2 Random number is : "+zoneTwoRandomNumber);
					System.out.println("Zone-3 Random number is : "+zoneThreeRandomNumber);
					System.out.println("Zone-4 Random number is : "+zoneFourRandomNumber);
					
					//Hiding Random values in zones
					try 
					{
						HidingRandomValue.zoneOneRandomValueHidingProcess(main_Img, stegnoImage1Path, zoneOneRandomNumber);
						HidingRandomValue.zoneTwoRandomValueHidingProcess(stegnoImage1Path, stegnoImage2Path, zoneTwoRandomNumber);
						HidingRandomValue.zoneThreeRandomValueHidingProcess(stegnoImage2Path, stegnoImage3Path, zoneThreeRandomNumber);
						HidingRandomValue.zoneFourRandomValueHidingProcess(stegnoImage3Path, stegnoImage4Path, zoneFourRandomNumber);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					
					ZoneOneHidingProcess.RPH1 = 0;
					ZoneOneHidingProcess.str2ZoneOne = "";
					ZoneOneHidingProcess.str3ZoneOne = "";
					ZoneOneHidingProcess.sec2ZoneOne.clear();
					ZoneOneHidingProcess.listZoneOne.clear();
					ZoneOneHidingProcess.ZoneOneDataList.clear();
					ZoneOneHidingProcess.ZoneOneDataBinaryList.clear();
					
					
					ZoneTwoHidingProcess.RPH2 = 0;
					ZoneTwoHidingProcess.str2ZoneTwo = "";
					ZoneTwoHidingProcess.str3ZoneTwo = "";
					ZoneTwoHidingProcess.sec2ZoneTwo.clear();
					ZoneTwoHidingProcess.listZoneTwo.clear();
					ZoneTwoHidingProcess.ZoneTwoDataList.clear();
					ZoneTwoHidingProcess.ZoneTwoDataBinaryList.clear();
					
					
					ZoneThreeHidingProcess.RPH3 = 0;
					ZoneThreeHidingProcess.str2ZoneThree = "";
					ZoneThreeHidingProcess.str3ZoneThree = "";
					ZoneThreeHidingProcess.sec2ZoneThree.clear();
					ZoneThreeHidingProcess.listZoneThree.clear();
					ZoneThreeHidingProcess.ZoneThreeDataList.clear();
					ZoneThreeHidingProcess.ZoneThreeDataBinaryList.clear();
					
					ZoneFourHidingProcess.RPH4 = 0;
					ZoneFourHidingProcess.str2ZoneFour = "";
					ZoneFourHidingProcess.str3ZoneFour = "";
					ZoneFourHidingProcess.sec2ZoneFour.clear();
					ZoneFourHidingProcess.listZoneFour.clear();
					ZoneFourHidingProcess.ZoneFourDataList.clear();
					ZoneFourHidingProcess.ZoneFourDataBinaryList.clear();
					
					
					
					try 
					{
						ZoneOneHidingProcess.zoneOneHideProcess(stegnoImage4Path, stegnoImage5Path, enc_Sec_ImgPath, zoneOneRandomNumber);
						ZoneTwoHidingProcess.zoneTwoHideProcess(stegnoImage5Path, stegnoImage6Path, enc_Sec_ImgPath, zoneTwoRandomNumber);
						ZoneThreeHidingProcess.zoneThreeHideProcess(stegnoImage6Path, stegnoImage7Path, enc_Sec_ImgPath, zoneThreeRandomNumber);
						ZoneFourHidingProcess.zoneFourHideProcess(stegnoImage7Path, stegnoImage8Path, enc_Sec_ImgPath, zoneFourRandomNumber);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					
					dao.makeTrans(id, select3, num+"stegnoImage8.png", sub);
					rs=dao.getInbox(id);
					request.setAttribute("rs", rs);
					request.setAttribute("name", id);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=1");
					rd.forward(request, response);
					}
				}
				else
				{
					ResultSet rs1=dao.getImageName("", id);
					ResultSet rs2=dao.getSecretImageName("", id);
					DAOFactory factory=new DAOFactory();
					DAO dao1=factory.getInstance("User");
					ResultSet rs3=dao1.getUsers();
					request.setAttribute("rs", rs);
					request.setAttribute("name", id);
					request.setAttribute("rs1", rs1);
					request.setAttribute("rs2", rs2);
					request.setAttribute("rs3", rs3);
					request.setAttribute("name", id);
					/*request.setAttribute("rs1", rs1);
					request.setAttribute("rs2", rs2);*/
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=6&no1=102");
					rd.forward(request, response);
				}
//				Utility.hideProcess(bmpinfile, bmpoutfile, intxt);
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User HideProcess ImageList......"+e);
			out.println("Opps's Error is in User HideProcess ImageList......"+e);
		}
	}
}
