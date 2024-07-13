package com.nits.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ZoneFourHidingProcess 
{
	static int RPH4 = 0;
	static String str2ZoneFour = "";
	static String str3ZoneFour = "";
	static ArrayList<String> sec2ZoneFour = new ArrayList<String>();
	static ArrayList<Integer> listZoneFour =new ArrayList<Integer>();
	static ArrayList<Integer> ZoneFourDataList = new ArrayList<Integer>();
	static ArrayList<String> ZoneFourDataBinaryList = new ArrayList<String>();
	static int zoneFourBitAdditionCount = 0;
	
	public static void zoneFourHideProcess(String stegnoImage7Path, String stegnoImage8Path, String secImgPath, int zoneFourRandomNumber)
	{
		System.out.println("Zone-4 Random number inside zone-4 hiding process is : "+zoneFourRandomNumber);
		RPH4 = 0;
		str2ZoneFour = "";
		str3ZoneFour = "";
		sec2ZoneFour.clear();
		listZoneFour.clear();
		ZoneFourDataList.clear();
		ZoneFourDataBinaryList.clear();
		
		int hide_pix_countZoneFour = 0;
		int zoneFourCount = 0;
		System.out.println("========================== Zone-4 Started ==============================");
		byte []zoneFourData = Image_To_Zone_Four_Division.image_To_Zone_Four_Division(secImgPath);
		System.out.println("zone-4 data length in side zone-4 is : "+zoneFourData.length);
		
		int zoneFourMsgLen1 = zoneFourData.length;
		String zoneFourDataLen;
		zoneFourDataLen = DataHiding.getStringLength(zoneFourMsgLen1);
		System.out.println("Meta data for zone-4 is : "+zoneFourDataLen);
		
		int zoneFourMsgLen = zoneFourData.length;
		ZoneFourHidingProcess.RPH4 = zoneFourMsgLen * 2;
	
		for(int b=0;b<zoneFourData.length;b++)
		{
			//System.out.println("zone-1 data is : "+zoneOneData[b]);
			ZoneFourDataList.add((int) zoneFourData[b]); 
		}
		
		for(int i=0; i<ZoneFourDataList.size();i++)
		{
			ZoneFourDataBinaryList.add(DataHiding.getBinary1(ZoneFourDataList.get(i)));
		}
		
		for (String i2 : ZoneFourDataBinaryList) 
		{
			str2ZoneFour+= i2;
		}
		int len2 = str2ZoneFour.length();

		for(int j=0;j<len2;j=j+4)
		{
			for(int i=j;i<j+4;i++)
			{
				char c2= str2ZoneFour.charAt(i);
				str3ZoneFour += c2;	
			}
			sec2ZoneFour.add(str3ZoneFour);
			str3ZoneFour="";
		}
		
		BufferedImage img = null;
		img = DataHiding.readImage(stegnoImage7Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Width of the image : "+width);
		System.out.println("Height of the image : "+height);
	//Writing modified pixel values in Zone-4
	try
	{
		zoneFourBitAdditionCount = 0;
		int[] zoneFourPix_Color = new int[4];
		for (int j = (height/2)+2; j < height; j++) 
		{
			for (int i = (width/2)+1; i < width; i++) 
			{
				int pixel = img.getRGB(i, j);
				zoneFourPix_Color = DataHiding.getARGBPixelData(pixel);
				if((i % zoneFourRandomNumber == 0) && (hide_pix_countZoneFour < ZoneFourHidingProcess.RPH4))
				{
					//System.out.println("Zone-4 Red Color index ("+i+","+j+") value is : "+pix_color[0]);
					
					int key77=ZoneFourHidingProcess.zoneFourHideSecretData(zoneFourPix_Color[0]);
					//System.out.println("key77 :"+key77);
		
		
					Color newColor = new Color(key77, zoneFourPix_Color[1], zoneFourPix_Color[2]);
					img.setRGB(i, j, newColor.getRGB());
					
					hide_pix_countZoneFour++;
				}
				else
				{
					Color newColor = new Color(zoneFourPix_Color[0], zoneFourPix_Color[1], zoneFourPix_Color[2]);
					img.setRGB(i, j, newColor.getRGB());
				}
			}
		}	
		File ouptut = new File(stegnoImage8Path);
		ImageIO.write(img, "png", ouptut);
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
	for(int i=0;i<ZoneFourHidingProcess.RPH4;i++)
	{
		//System.out.println("The "+ i+" Pixel decimal value which is hiding in zone-4 is :"+list1ZoneFour.get(i));
	}
		
}
	
	public static int zoneFourHideSecretData(int num)
	{ 
		String zoneFourPixelBinaryNum="";
		String zoneFourP1 ="";
		String zoneFourRes = "";
		zoneFourPixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
	    zoneFourP1 = zoneFourPixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
	    String zoneFourBit = "";
	   
	    zoneFourBit = sec2ZoneFour.get(zoneFourBitAdditionCount);
	    
	    zoneFourBitAdditionCount++;
	    
	    int decimal2=0;
		int num5=0;
		zoneFourRes = zoneFourP1+zoneFourBit; //adding 4 bit pixel and 4 bit secret message
		//System.out.println("Modified pixel binary value is : "+res);
		num5= Integer.parseInt(zoneFourRes); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		//listZoneOne.add(decimal2);
		return decimal2;
	
	}
}
