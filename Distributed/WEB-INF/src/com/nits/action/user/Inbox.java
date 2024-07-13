/**
 * 
 */
package com.nits.action.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
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


public class Inbox extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		try
		{
			String submit=request.getParameter("submit");
			String id=request.getParameter("name");
			CommonDAO dao=CommonDAO.getInstance();
			ResultSet rs=dao.getInbox(id);
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				request.setAttribute("name", id);
				rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp");
				rd.forward(request, response);
			}
			if(submit.equals("Create"))
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
				rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=6");
				rd.forward(request, response);
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						File f=new File(getServletContext().getRealPath("/")+"/Resources/Images/Messages/"+dao.getMessageImageName(chk[i]));
						dao.deleteMessageImage(chk[i]);
						f.delete();
					}
					rs=dao.getInbox(id);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=3");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Extract"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length>1)
				{
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=4");
					rd.forward(request,response);
				}
				else
				{
					String Ext_Enc_Sec_Img_path = request.getRealPath("")+"/Resources/Images/Ext_Enc_Sec_Img/Ext_Enc_Sec_Img.png";
					String dec_Sec_Img_path = request.getRealPath("")+"/Resources/Images/Dec_Sec_Img/Dec_Img.jpg";
					String waterMarkedImagePath = request.getRealPath("")+"/Resources/Images/Messages/"+dao.getMessageImageName(chk[0]);				
					
					
					int zoneOneRandomNumber = 0;
					int zoneTwoRandomNumber = 0;
					int zoneThreeRandomNumber = 0;
					int zoneFourRandomNumber = 0;
					
					try
					{
						zoneOneRandomNumber = RandomValueRetrieval.zoneOneRandomValueRetrievalProcess(waterMarkedImagePath);
						zoneTwoRandomNumber = RandomValueRetrieval.zoneTwoRandomValueRetrievalProcess(waterMarkedImagePath);
						zoneThreeRandomNumber = RandomValueRetrieval.zoneThreeRandomValueRetrievalProcess(waterMarkedImagePath);
						zoneFourRandomNumber = RandomValueRetrieval.zoneFourRandomValueRetrievalProcess(waterMarkedImagePath);
					} 
					catch (Exception e) 
					{
						
						e.printStackTrace();
					}
					
					try
					{
						// zone-1 decryption started
						ArrayList<String> zoneOnetotalPix2 = new ArrayList<String>();
						zoneOnetotalPix2 = ZoneOneDecryption.zoneOneDecryptionProcess(waterMarkedImagePath, zoneOneRandomNumber);
						ZoneOneDecryption.getSecretMsg2(zoneOnetotalPix2);
						
						System.out.println("zone-1 random number for decryption is "+zoneOneRandomNumber);
						
						System.out.println("Hidden image data Length in zone-1 is :"+ZoneOneDecryption.zoneOneMsgLength5);
						ZoneOneDecryption.zoneOnesecretMsgLength = ((ZoneOneDecryption.zoneOneMsgLength5*2));
						System.out.println("Complete secret message length in zone-1 is : "+ZoneOneDecryption.zoneOnesecretMsgLength);
						
						ZoneOneDecryption.zoneOneDecryptionProcess2(waterMarkedImagePath, ZoneOneDecryption.zoneOnesecretMsgLength, zoneOneRandomNumber);
						ZoneOneDecryption.getSecretMsg5();
						// zone-1 decryption end
				
						
						// zone-2 decryption started
						ArrayList<String> zoneTwototalPix2 = new ArrayList<String>();
						zoneTwototalPix2 = ZoneTwoDecryption.zoneTwoDecryptionProcess(waterMarkedImagePath, zoneTwoRandomNumber);
						ZoneTwoDecryption.getSecretMsg2(zoneTwototalPix2);
						System.out.println("zone-2 random number for decryption is "+zoneTwoRandomNumber);
								
						System.out.println("secret MSG Length in zone-2 is :"+ZoneTwoDecryption.zoneTwoMsgLength5);
						ZoneTwoDecryption.zoneTwosecretMsgLength = ((ZoneTwoDecryption.zoneTwoMsgLength5*2));
						System.out.println("Complete secret message length in zone-2 is : "+ZoneTwoDecryption.zoneTwosecretMsgLength);
									
						ZoneTwoDecryption.zoneTwoDecryptionProcess2(waterMarkedImagePath, ZoneTwoDecryption.zoneTwosecretMsgLength, zoneTwoRandomNumber);
						ZoneTwoDecryption.getSecretMsg5();
						// zone-2 decryption end
				
						// zone-3 decryption started
						ZoneThreeDecryption.zoneThreeDecryptionProcess(waterMarkedImagePath, zoneThreeRandomNumber);
						ZoneThreeDecryption.getSecretMsg2();
						
						System.out.println("zone-3 random number for decryption is "+zoneThreeRandomNumber);
											
						System.out.println("secret MSG Length in zone-3 is :"+ZoneThreeDecryption.zoneThreeMsgLength5);
						ZoneThreeDecryption.zoneThreesecretMsgLength = ((ZoneThreeDecryption.zoneThreeMsgLength5*2));
						System.out.println("Complete secret message length in zone-3 is : "+ZoneThreeDecryption.zoneThreesecretMsgLength);
												
						ZoneThreeDecryption.zoneThreeDecryptionProcess2(waterMarkedImagePath, ZoneThreeDecryption.zoneThreesecretMsgLength, zoneThreeRandomNumber);
						ZoneThreeDecryption.getSecretMsg5();
						// zone-3 decryption end
				
						// zone-4 decryption started
						ZoneFourDecryption.zoneFourDecryptionProcess(waterMarkedImagePath, zoneFourRandomNumber);
						ZoneFourDecryption.getSecretMsg2();
						
						System.out.println("zone-4 random number for decryption is "+zoneFourRandomNumber);
														
						System.out.println("secret MSG Length in zone-4 is :"+ZoneFourDecryption.zoneFourMsgLength5);
						ZoneFourDecryption.zoneFoursecretMsgLength = ((ZoneFourDecryption.zoneFourMsgLength5*2));
						System.out.println("Complete secret message length in zone-4 is : "+ZoneFourDecryption.zoneFoursecretMsgLength);
															
						ZoneFourDecryption.zoneFourDecryptionProcess2(waterMarkedImagePath, ZoneFourDecryption.zoneFoursecretMsgLength, zoneFourRandomNumber);
						ZoneFourDecryption.getSecretMsg5();
						// zone-4 decryption end
						
						/*int count10 =0;
						int count11 =0;
						int count12 =0;
						int count13 =0;
						for(int i=0;i<ZoneOneDecryption.ZoneOneExtValue.size();i++)
						{
							System.out.println("zone-1 ExtValue is : "+ZoneOneDecryption.ZoneOneExtValue.get(i));
							count10++;
							
						}
						for(int i=0;i<ZoneTwoDecryption.ZoneTwoExtValue.size();i++)
						{
							System.out.println("zone-2 ExtValue is : "+ZoneTwoDecryption.ZoneTwoExtValue.get(i));
							count11++;
							
						}
						for(int i=0;i<ZoneThreeDecryption.ZoneThreeExtValue.size();i++)
						{
							System.out.println("zone-3 ExtValue is : "+ZoneThreeDecryption.ZoneThreeExtValue.get(i));
							count12++;
							
						}for(int i=0;i<ZoneFourDecryption.ZoneFourExtValue.size();i++)
						{
							System.out.println("zone-4 ExtValue is : "+ZoneFourDecryption.ZoneFourExtValue.get(i));
							count13++;
							
						}
						System.out.println("zone-1 count is "+count10);
						System.out.println("zone-2 count is "+count11);
						System.out.println("zone-3 count is "+count12);
						System.out.println("zone-4 count is "+count13);*/
						
						int zoneOneValueLength = ZoneOneDecryption.ZoneOneExtValue.size();
						int zoneTwoValueLength = ZoneTwoDecryption.ZoneTwoExtValue.size();
						int zoneThreeValueLength = ZoneThreeDecryption.ZoneThreeExtValue.size();
						int zoneFourValueLength = ZoneFourDecryption.ZoneFourExtValue.size();
						System.out.println("zone-4 ext value size is +++++++++++++++++++++++++++ : "+zoneFourValueLength);
						
						int totalLength = (zoneOneValueLength+zoneTwoValueLength+zoneThreeValueLength+zoneFourValueLength);
						
						byte[] content = new byte[totalLength];
						int count=0;
						for(int k=5;k<zoneOneValueLength;k++)
						{
							
								content[count++] = (byte)Integer.parseInt(ZoneOneDecryption.ZoneOneExtValue.get(k));
						
								content[count++] = (byte)Integer.parseInt(ZoneTwoDecryption.ZoneTwoExtValue.get(k));
								
								content[count++] = (byte)Integer.parseInt(ZoneThreeDecryption.ZoneThreeExtValue.get(k));
								
								content[count++] = (byte)Integer.parseInt(ZoneFourDecryption.ZoneFourExtValue.get(k));
							
						}
						for(int j=zoneOneValueLength; j < zoneFourValueLength ;j++)
						{
							content[count++] = (byte)Integer.parseInt(ZoneFourDecryption.ZoneFourExtValue.get(j));
							
							System.out.println("mod count value is : "+count);
						}
						count = 0;
						
			//Map Array for getting Interger value sutiable for byte
						
						int map_array[] = new  int[256];
						
						for(int j = 0;j<128;j++)
						{
							map_array[j] = j;
							
						}
						
						map_array[128] =0;
						int c = 1;
						for(int j = 255;j>=128;j--)
						{
							map_array[j] = c * -1;
							c++;
							
						}
						
						for(int j = 0;j<256;j++)
						{
							//System.out.println(j+"-"+map_array[j]);
						}
						
						byte[] ext_content = new byte[content.length];
						byte[] ext_content1 = new byte[content.length];
						
						for(int i = 0; i < content.length; i++)
						{
							byte k = content[i];
							int kk = (int)k;
							String s = ("0000000" + Integer.toBinaryString(0xFF & k)).replaceAll(".*(.{8})$", "$1");
							//int val = k;
							Integer val = Integer.parseInt(s,2);
							try 
							{
								//System.out.println("Binary Value ==>"+s);
								//System.out.println("Integer Value ==>"+kk);
								//stream.write(val);
								int write_val = map_array[val];
								ext_content[i] = (byte)write_val;
								ext_content1[i] = k;
								
								
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							
						}
						
					
						
						//byte[] output=Utility.extractProcess(f);
						
					   
						
						FileOutputStream fos = new FileOutputStream(Ext_Enc_Sec_Img_path);
						fos.write(ext_content1);
						
						fos.close();
						
					} 
					catch (Exception e) 
					{
						
						e.printStackTrace();
					}
					
					//String Ext_Enc_Sec_Img_path2 = "Ext_Enc_Sec_Img.png";
					
					String password="password12345678";
					String dec_path = AES_File_EncNdec.decryptFile(Ext_Enc_Sec_Img_path, dec_Sec_Img_path, password);
					//System.out.println("total pixel selected for hiding is : "+ZoneTwoHidingProcess.hide_pix_countZoneTwo);
					
					System.out.println("");
					System.out.println("Process completed");

					rs=dao.getInbox(id);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/inbox.jsp?no=7");
					rd.forward(request,response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin Inbox Servlet......"+e);
			out.println("Opps's Error is in Admin Inbox Servlet......"+e);
		}
	}
}
