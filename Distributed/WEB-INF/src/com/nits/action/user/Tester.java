package com.nits.action.user;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;



/*
public class Tester 
{

	public static void main(String[] args) 
	{
		String secImagePath = "BMW_logo.jpg";
		String enc_Sec_ImgPath = "enc_sec_image.png";
		String Ext_Enc_Sec_Img_path = "Ext_Enc_Sec_Img.png";
		String DecSecImgpath2 = "Dec_Sec_Img.jpg";
		
		String mainImagePath = "Aloe_Vera.jpg";
		String stegnoImage1Path = "stegnoImage1.png";
		String stegnoImage2Path = "stegnoImage2.png";
		String stegnoImage3Path = "stegnoImage3.png";
		String stegnoImage4Path = "stegnoImage4.png";
		String stegnoImage5Path = "stegnoImage5.png";
		String stegnoImage6Path = "stegnoImage6.png";
		String stegnoImage7Path = "stegnoImage7.png";
		String stegnoImage8Path = "stegnoImage8.png";
		
		*/
		/*String password="password12345678";
		
		try 
		{
			AES_File_EncNdec.encryptFile(secImagePath, enc_Sec_ImgPath, password);
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		*/
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter Text Message");
		String text = sc.nextLine();
		Text_To_Zone_Division.text_To_Zone_Division(text);
		*/
		
		
		/*int randomNum1 = DataHiding.getRandomNumber();
		int randomNum2 = DataHiding.getRandomNumber();
		int randomNum3 = DataHiding.getRandomNumber();
		int randomNum4 = DataHiding.getRandomNumber();
		System.out.println("Random number-1 value is : "+randomNum1);
		System.out.println("Random number-2 value is : "+randomNum2);
		System.out.println("Random number-3 value is : "+randomNum3);
		System.out.println("Random number-4 value is : "+randomNum4);*/
		
		
		/*//Hiding Random values in zones
		try 
		{
			HidingRandomValue.zoneOneRandomValueHidingProcess(mainImagePath);
			HidingRandomValue.zoneTwoRandomValueHidingProcess(stegnoImage1Path);
			HidingRandomValue.zoneThreeRandomValueHidingProcess(stegnoImage2Path);
			HidingRandomValue.zoneFourRandomValueHidingProcess(stegnoImage3Path);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
		
		
		
		/*//Hiding text data in zones
		ZoneOneHidingProcess zoneOne = new ZoneOneHidingProcess();
		ZoneTwoHidingProcess zoneTwo = new ZoneTwoHidingProcess();
		ZoneThreeHidingProcess zoneThree = new ZoneThreeHidingProcess();
		ZoneFourHidingProcess zoneFour = new ZoneFourHidingProcess();
		try 
		{
			zoneOne.zoneOneHideProcess(stegnoImage4Path, enc_Sec_ImgPath);
			zoneTwo.zoneTwoHideProcess(stegnoImage5Path, enc_Sec_ImgPath);
			zoneThree.zoneThreeHideProcess(stegnoImage6Path, enc_Sec_ImgPath);
			zoneFour.zoneFourHideProcess(stegnoImage7Path, enc_Sec_ImgPath);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
		
		
		/*try
		{
			RandomValueRetrieval.zoneOneRandomValueRetrievalProcess(stegnoImage8Path);
			RandomValueRetrieval.zoneTwoRandomValueRetrievalProcess(stegnoImage8Path);
			RandomValueRetrieval.zoneThreeRandomValueRetrievalProcess(stegnoImage8Path);
			RandomValueRetrieval.zoneFourRandomValueRetrievalProcess(stegnoImage8Path);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}*/
		
		/*try
		{
		*/	/*// zone-1 decryption started
			ZoneOneDecryption.zoneOneDecryptionProcess(stegnoImage8Path);
			ZoneOneDecryption.getSecretMsg2();
			
			System.out.println("secret MSG Length in zone-1 is :"+ZoneOneDecryption.zoneOneMsgLength5);
			ZoneOneDecryption.zoneOnesecretMsgLength = ((ZoneOneDecryption.zoneOneMsgLength5*2));
			System.out.println("Complete secret message length in zone-1 is : "+ZoneOneDecryption.zoneOnesecretMsgLength);
			
			ZoneOneDecryption.zoneOneDecryptionProcess2(stegnoImage8Path, ZoneOneDecryption.zoneOnesecretMsgLength);
			ZoneOneDecryption.getSecretMsg5();
			// zone-1 decryption end
	
			// zone-2 decryption started
			ZoneTwoDecryption.zoneTwoDecryptionProcess(stegnoImage8Path);
			ZoneTwoDecryption.getSecretMsg2();
					
			System.out.println("secret MSG Length in zone-2 is :"+ZoneTwoDecryption.zoneTwoMsgLength5);
			ZoneTwoDecryption.zoneTwosecretMsgLength = ((ZoneTwoDecryption.zoneTwoMsgLength5*2));
			System.out.println("Complete secret message length in zone-2 is : "+ZoneTwoDecryption.zoneTwosecretMsgLength);
						
			ZoneTwoDecryption.zoneTwoDecryptionProcess2(stegnoImage8Path, ZoneTwoDecryption.zoneTwosecretMsgLength);
			ZoneTwoDecryption.getSecretMsg5();
			// zone-2 decryption end
	
			// zone-3 decryption started
			ZoneThreeDecryption.zoneThreeDecryptionProcess(stegnoImage8Path);
			ZoneThreeDecryption.getSecretMsg2();
								
			System.out.println("secret MSG Length in zone-3 is :"+ZoneThreeDecryption.zoneThreeMsgLength5);
			ZoneThreeDecryption.zoneThreesecretMsgLength = ((ZoneThreeDecryption.zoneThreeMsgLength5*2));
			System.out.println("Complete secret message length in zone-3 is : "+ZoneThreeDecryption.zoneThreesecretMsgLength);
									
			ZoneThreeDecryption.zoneThreeDecryptionProcess2(stegnoImage8Path, ZoneThreeDecryption.zoneThreesecretMsgLength);
			ZoneThreeDecryption.getSecretMsg5();
			// zone-3 decryption end
	
			// zone-4 decryption started
			ZoneFourDecryption.zoneFourDecryptionProcess(stegnoImage8Path);
			ZoneFourDecryption.getSecretMsg2();
											
			System.out.println("secret MSG Length in zone-4 is :"+ZoneFourDecryption.zoneFourMsgLength5);
			ZoneFourDecryption.zoneFoursecretMsgLength = ((ZoneFourDecryption.zoneFourMsgLength5*2));
			System.out.println("Complete secret message length in zone-4 is : "+ZoneFourDecryption.zoneFoursecretMsgLength);
												
			ZoneFourDecryption.zoneFourDecryptionProcess2(stegnoImage8Path, ZoneFourDecryption.zoneFoursecretMsgLength);
			ZoneFourDecryption.getSecretMsg5();
			// zone-4 decryption end
			*/
			
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
			
			
			
			
			
			
			
			 

			
			/*byte[] content = new byte[1301];
			int count=0;
			for(int k=5;k<330;k++)
			{
				
					content[count++] = (byte)Integer.parseInt(ZoneOneDecryption.ZoneOneExtValue.get(k));
			
					content[count++] = (byte)Integer.parseInt(ZoneTwoDecryption.ZoneTwoExtValue.get(k));
					
					content[count++] = (byte)Integer.parseInt(ZoneThreeDecryption.ZoneThreeExtValue.get(k));
					
					content[count++] = (byte)Integer.parseInt(ZoneFourDecryption.ZoneFourExtValue.get(k));
				
			}
			for(int j=330; j < 331 ;j++)
			{
				content[count++] = (byte)Integer.parseInt(ZoneFourDecryption.ZoneFourExtValue.get(j));
				
				System.out.println("count value is : "+count);
			}
			
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
					System.out.println("Binary Value ==>"+s);
					System.out.println("Integer Value ==>"+kk);
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
			
		*/
			
			/*//byte[] output=Utility.extractProcess(f);
			
			FileOutputStream fos = new FileOutputStream(Ext_Enc_Sec_Img_path);
			fos.write(ext_content1);
			fos.close();
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		*/
		//String Ext_Enc_Sec_Img_path2 = "Ext_Enc_Sec_Img.png";
		
		/*String password="password12345678";
		
		try 
		{
			AES_File_EncNdec.decryptFile(Ext_Enc_Sec_Img_path, DecSecImgpath2, password);
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		//System.out.println("total pixel selected for hiding is : "+ZoneTwoHidingProcess.hide_pix_countZoneTwo);
		
		System.out.println("");
		System.out.println("Process completed");

	}

}
*/