package com.nits.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ZoneOneHidingProcess 
{
	static int RPH1 = 0;
	
	static String str2ZoneOne = "";
	static String str3ZoneOne = "";
	static ArrayList<String> sec2ZoneOne = new ArrayList<String>();
	static ArrayList<Integer> listZoneOne =new ArrayList<Integer>();
	
	static ArrayList<Integer> ZoneOneDataList = new ArrayList<Integer>();
	static ArrayList<String> ZoneOneDataBinaryList = new ArrayList<String>();
	
	
	
	static int bitAdditionCount = 0;
	
	
	public static void zoneOneHideProcess(String stegnoImage4Path, String stegnoImage5Path, String secImgPath, int zoneOneRandomNumber)
	{
		RPH1 = 0;
		str2ZoneOne = "";
		str3ZoneOne = "";
		sec2ZoneOne.clear();
		listZoneOne.clear();
		ZoneOneDataList.clear();
		ZoneOneDataBinaryList.clear();
		
		
		bitAdditionCount = 0;
		
		int zoneOneCount =0;
		int hide_pix_countZoneOne = 0;
		System.out.println("========================== Zone-1 Started ==============================");
		System.out.println("Zone-1 Random number inside zone-1 hiding process is : "+zoneOneRandomNumber);
		
		byte []zoneOneData = Image_To_Zone_One_Division.image_To_Zone_One_Division(secImgPath);
		System.out.println("zone-1 data length in side zone-1 is : "+zoneOneData.length);
		
		int zoneOneMsgLen1 = zoneOneData.length;
		String zoneOneDataLen;
		zoneOneDataLen = DataHiding.getStringLength(zoneOneMsgLen1);
		System.out.println("Meta data for zone-1 is : "+zoneOneDataLen);
		
		int zoneOneMsgLen = zoneOneData.length;
		ZoneOneHidingProcess.RPH1 = zoneOneMsgLen * 2;
		System.out.println("RPH1 Value is : "+RPH1);
	
		for(int b=0;b<zoneOneData.length;b++)
		{
			ZoneOneDataList.add((int) zoneOneData[b]); 
		}
		
		for(int i=0; i<ZoneOneDataList.size();i++)
		{
			ZoneOneDataBinaryList.add(DataHiding.getBinary1(ZoneOneDataList.get(i)));
		}
		
		for (String i2 : ZoneOneDataBinaryList) 
		{
			str2ZoneOne+= i2;
		}
		int len2 = str2ZoneOne.length();

		for(int j=0;j<len2;j=j+4)
		{
			for(int i=j;i<j+4;i++)
			{
				char c2= str2ZoneOne.charAt(i);
				str3ZoneOne += c2;	
			}
			sec2ZoneOne.add(str3ZoneOne);
			str3ZoneOne="";
		}
		
		for(int i=0; i<sec2ZoneOne.size();i++)
		{
			//System.out.println("sec2ZoneOne content is : "+sec2ZoneOne.get(i));
		}
		
		BufferedImage img = null;
		img = DataHiding.readImage(stegnoImage4Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Width of the image : "+width);
		System.out.println("Height of the image : "+height);
		//Writing modified pixel values in Zone-1
		try
		{
			int[] zoneOnePix_Color = new int[4];
			for (int j = 0; j < height/2; j++) 
			{
				for (int i = 0; i < width/2; i++) 
				{
					int pixel = img.getRGB(i, j);
					zoneOnePix_Color = DataHiding.getARGBPixelData(pixel);
					if((i % zoneOneRandomNumber == 0) && (hide_pix_countZoneOne < ZoneOneHidingProcess.RPH1))
					{
						//System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
						
						int key77 = ZoneOneHidingProcess.zoneOneHideSecretData(zoneOnePix_Color[0]);
						//System.out.println("key77 :"+key77);
						
						
						Color newColor = new Color(key77, zoneOnePix_Color[1], zoneOnePix_Color[2]);
						img.setRGB(i, j, newColor.getRGB());
						
						hide_pix_countZoneOne++;
					}
					else
					{
					Color newColor = new Color(zoneOnePix_Color[0], zoneOnePix_Color[1], zoneOnePix_Color[2]);
					img.setRGB(i, j, newColor.getRGB());
					}
				}
			}	
			File ouptut = new File(stegnoImage5Path);
			ImageIO.write(img, "png", ouptut);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		for(int i=0;i<ZoneOneHidingProcess.RPH1;i++)
		{
			//System.out.println("The "+ i+" Pixel decimal value which is hiding in zone-1 is :"+list1ZoneOne.get(i));
		}
					
	}
	
	public static int zoneOneHideSecretData(int num)
	{ 
		String zoneOnePixelBinaryNum="";
		String zoneOneP1 ="";
		String zoneOneRes = "";
		zoneOnePixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
	    zoneOneP1 = zoneOnePixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
	    String zoneoneBit = "";
	   
	    zoneoneBit = sec2ZoneOne.get(bitAdditionCount);
	    
	    bitAdditionCount++;
	    
	    int decimal2=0;
		int num5=0;
		zoneOneRes = zoneOneP1+zoneoneBit; //adding 4 bit pixel and 4 bit image data
		//System.out.println("Modified pixel binary value is : "+res);
		num5= Integer.parseInt(zoneOneRes); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		//listZoneOne.add(decimal2);
		return decimal2;
	
	}
	
}
