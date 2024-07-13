package com.nits.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ZoneThreeHidingProcess 
{
	static int RPH3 = 0;
	static String str2ZoneThree = "";
	static String str3ZoneThree = "";
	static ArrayList<String> sec2ZoneThree = new ArrayList<String>();
	static ArrayList<Integer> listZoneThree =new ArrayList<Integer>();
	static ArrayList<Integer> ZoneThreeDataList = new ArrayList<Integer>();
	static ArrayList<String> ZoneThreeDataBinaryList = new ArrayList<String>();
	static int zoneThreeBitAdditionCount = 0;
	
	
	public static void zoneThreeHideProcess(String stegnoImage6Path, String stegnoImage7Path, String secImgPath, int zoneThreeRandomNumber)
	{
		System.out.println("Zone-3 Random number inside zone-3 hiding process is : "+zoneThreeRandomNumber);
		RPH3 = 0;
		str2ZoneThree = "";
		str3ZoneThree = "";
		sec2ZoneThree.clear();
		listZoneThree.clear();
		ZoneThreeDataList.clear();
		ZoneThreeDataBinaryList.clear();
		
		
		int zoneThreeCount = 0;
		int hide_pix_countZoneThree = 0;
		System.out.println("========================== Zone-3 Started ==============================");
		
		byte []zoneThreeData = Image_To_Zone_Three_Division.image_To_Zone_Three_Division(secImgPath);
		System.out.println("zone-3 data length in side zone-3 is : "+zoneThreeData.length);
		
		int zoneThreeMsgLen1 = zoneThreeData.length;
		String zoneThreeDataLen;
		zoneThreeDataLen = DataHiding.getStringLength(zoneThreeMsgLen1);
		System.out.println("Meta data for zone-3 is : "+zoneThreeDataLen);
		
		int zoneThreeMsgLen = zoneThreeData.length;
		ZoneThreeHidingProcess.RPH3 = zoneThreeMsgLen * 2;
	
		
		for(int b=0;b<zoneThreeData.length;b++)
		{
			//System.out.println("zone-3 data is : "+zoneThreeData[b]);
			ZoneThreeDataList.add((int) zoneThreeData[b]); 
		}
		
		for(int i=0; i<ZoneThreeDataList.size();i++)
		{
			ZoneThreeDataBinaryList.add(DataHiding.getBinary1(ZoneThreeDataList.get(i)));
		}
		
		for (String i2 : ZoneThreeDataBinaryList) 
		{
			str2ZoneThree+= i2;
		}
		int len2 = str2ZoneThree.length();

		for(int j=0;j<len2;j=j+4)
		{
			for(int i=j;i<j+4;i++)
			{
				char c2= str2ZoneThree.charAt(i);
				str3ZoneThree += c2;	
			}
			sec2ZoneThree.add(str3ZoneThree);
			str3ZoneThree="";
		}
		
		BufferedImage img = null;
		img = DataHiding.readImage(stegnoImage6Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Width of the image : "+width);
		System.out.println("Height of the image : "+height);
	//Writing modified pixel values in Zone-3
	try
	{
		zoneThreeBitAdditionCount = 0;
		int[] zoneThreePix_Color = new int[4];
		for (int j = (height/2)+1; j < height; j++) 
		{
			for (int i = 0; i < width/2; i++) 
			{
				int pixel = img.getRGB(i, j);
				zoneThreePix_Color = DataHiding.getARGBPixelData(pixel);
				if((i % zoneThreeRandomNumber == 0) && (hide_pix_countZoneThree < ZoneThreeHidingProcess.RPH3))
				{
					//System.out.println("Zone-3 Red Color index ("+i+","+j+") value is : "+pix_color[0]);
				
					int key77 = ZoneThreeHidingProcess.zoneThreeHideSecretData(zoneThreePix_Color[0]);
					//System.out.println("key77 :"+key77);
			
			
					Color newColor = new Color(key77, zoneThreePix_Color[1], zoneThreePix_Color[2]);
					img.setRGB(i, j, newColor.getRGB());
					hide_pix_countZoneThree++;
				}
				else
				{
					Color newColor = new Color(zoneThreePix_Color[0], zoneThreePix_Color[1], zoneThreePix_Color[2]);
					img.setRGB(i, j, newColor.getRGB());
				}
			}
		}	
		File ouptut = new File(stegnoImage7Path);
		ImageIO.write(img, "png", ouptut);
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
	for(int i=0;i<ZoneThreeHidingProcess.RPH3;i++)
	{
		//System.out.println("The "+ i+" Pixel decimal value which is hiding in zone-3 is :"+list1ZoneThree.get(i));
	}
			
	}
	
	public static int zoneThreeHideSecretData(int num)
	{ 
		String zoneThreePixelBinaryNum="";
		String zoneThreeP1 ="";
		String zoneThreeRes = "";
		zoneThreePixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
	    zoneThreeP1 = zoneThreePixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
	    String zoneThreeBit = "";
	   
	    zoneThreeBit = sec2ZoneThree.get(zoneThreeBitAdditionCount);
	    
	    zoneThreeBitAdditionCount++;
	    
	    int decimal2=0;
		int num5=0;
		zoneThreeRes = zoneThreeP1+zoneThreeBit; //adding 4 bit pixel and 4 bit secret message
		//System.out.println("Modified pixel binary value is : "+res);
		num5= Integer.parseInt(zoneThreeRes); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		//listZoneOne.add(decimal2);
		return decimal2;
	
	}
}
