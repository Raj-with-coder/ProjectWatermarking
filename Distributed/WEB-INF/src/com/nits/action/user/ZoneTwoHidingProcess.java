package com.nits.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ZoneTwoHidingProcess 
{
	static int RPH2 = 0;
	static String str2ZoneTwo = "";
	static String str3ZoneTwo = "";
	static ArrayList<String> sec2ZoneTwo = new ArrayList<String>();
	static ArrayList<Integer> listZoneTwo =new ArrayList<Integer>();
	static ArrayList<Integer> ZoneTwoDataList = new ArrayList<Integer>();
	static ArrayList<String> ZoneTwoDataBinaryList = new ArrayList<String>();
	
	static int zoneTwoBitAdditionCount = 0;
	
	public static void zoneTwoHideProcess(String stegnoImage5Path, String stegnoImage6Path, String secImgPath, int zoneTwoRandomNumber)
	{
		System.out.println("Zone-2 Random number inside zone-2 hiding process is : "+zoneTwoRandomNumber);
		RPH2 = 0;
		str2ZoneTwo = "";
		str3ZoneTwo = "";
		sec2ZoneTwo.clear();
		listZoneTwo.clear();
		ZoneTwoDataList.clear();
		ZoneTwoDataBinaryList.clear();
		
		
		int hide_pix_countZoneTwo = 0;
		int zoneTwoCount = 0;
		System.out.println("========================== Zone-2 Started ==============================");
		
		byte []zoneTwoData = Image_To_Zone_Two_Division.image_To_Zone_Two_Division(secImgPath);
		System.out.println("zone-2 data length in side zone-2 is : "+zoneTwoData.length);
		
		int zoneTwoMsgLen1 = zoneTwoData.length;
		String zoneTwoDataLen;
		zoneTwoDataLen = DataHiding.getStringLength(zoneTwoMsgLen1);
		System.out.println("Meta data for zone-2 is : "+zoneTwoDataLen);
		
		int zoneTwoMsgLen = zoneTwoData.length;
		ZoneTwoHidingProcess.RPH2 = zoneTwoMsgLen * 2;
	
		
		for(int b=0;b<zoneTwoData.length;b++)
		{
			//System.out.println("zone-2 data is : "+zoneTwoData[b]);
			ZoneTwoDataList.add((int) zoneTwoData[b]); 
		}
		
		for(int i=0; i<ZoneTwoDataList.size();i++)
		{
			ZoneTwoDataBinaryList.add(DataHiding.getBinary1(ZoneTwoDataList.get(i)));
		}
		
		for (String i2 : ZoneTwoDataBinaryList) 
		{
			str2ZoneTwo+= i2;
		}
		int len2 = str2ZoneTwo.length();

		for(int j=0;j<len2;j=j+4)
		{
			for(int i=j;i<j+4;i++)
			{
				char c2= str2ZoneTwo.charAt(i);
				str3ZoneTwo += c2;	
			}
			sec2ZoneTwo.add(str3ZoneTwo);
			str3ZoneTwo = "";
		}
		
		
		//Zone-2 hiding position values.
		
		BufferedImage img = null;
		img = DataHiding.readImage(stegnoImage5Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Width of the image : "+width);
		System.out.println("Height of the image : "+height);
	//Writing modified pixel values in Zone-2
	try
	{
		zoneTwoBitAdditionCount = 0;
		int[] zoneTwoPix_Color = new int[4];
		for (int j = 0; j < height/2; j++) 
		{
			for (int i = (width/2)+1; i < width; i++) 
			{
				int pixel = img.getRGB(i, j);
				zoneTwoPix_Color = DataHiding.getARGBPixelData(pixel);
				if((i % zoneTwoRandomNumber == 0) && (hide_pix_countZoneTwo < RPH2))
				{
					//System.out.println("Zone-2 Red Color index ("+i+","+j+") value is : "+pix_color[0]);
					
					int key77=ZoneTwoHidingProcess.zoneTwoHideSecretData(zoneTwoPix_Color[0]);
					//System.out.println("key77 :"+key77);
				
				
					Color newColor = new Color(key77, zoneTwoPix_Color[1], zoneTwoPix_Color[2]);
					img.setRGB(i, j, newColor.getRGB());
					
					hide_pix_countZoneTwo++;
				}
				else
				{
					Color newColor = new Color(zoneTwoPix_Color[0], zoneTwoPix_Color[1], zoneTwoPix_Color[2]);
					img.setRGB(i, j, newColor.getRGB());
				}
			}
		}	
		File ouptut = new File(stegnoImage6Path);
		ImageIO.write(img, "png", ouptut);
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}

	}
	
	public static int zoneTwoHideSecretData(int num)
	{ 
		String zoneTwoPixelBinaryNum="";
		String zoneTwoP1 ="";
		String zoneTwoRes = "";
		zoneTwoPixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
	    zoneTwoP1 = zoneTwoPixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
	    String zoneTwoBit = "";
	   
	    zoneTwoBit = sec2ZoneTwo.get(zoneTwoBitAdditionCount);
	    
	    zoneTwoBitAdditionCount++;
	    
	    int decimal2=0;
		int num5=0;
		zoneTwoRes = zoneTwoP1+zoneTwoBit; //adding 4 bit pixel and 4 bit image data
		//System.out.println("Modified pixel binary value is : "+res);
		num5= Integer.parseInt(zoneTwoRes); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		//listZoneOne.add(decimal2);
		return decimal2;
	
	}

}
