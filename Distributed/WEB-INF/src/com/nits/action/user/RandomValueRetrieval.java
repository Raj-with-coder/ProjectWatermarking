package com.nits.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RandomValueRetrieval 
{
	static String randomPixelBinaryNum ="";
	static String random_P1="";
	static String random_Res = "";
	static int zoneOneHiddenNum = 0;
	static int zoneTwoHiddenNum = 0;
	static int zoneThreeHiddenNum = 0;
	static int zoneFourHiddenNum = 0;
	

	public static int randomBitExtraction(int num)
	{ 
		//adding six bit form pixel and two bit from secret message
		
		randomPixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
		random_P1 = randomPixelBinaryNum.substring(4);//taking four bit form pixel 8 bit
		
		int decimal2=0;
		int num5=0;
		/*int randomNumber = DataHiding.getRandomNumber();
		System.out.println("Random number is : "+randomNumber);
		String randomNumToBinary = DataHiding.getBinary1(randomNumber);
		String lastFourBitOfRandomNum = randomNumToBinary.substring(4);*/
		
		random_Res = random_P1; //adding 4 bit pixel and 4 bit random number bit
		System.out.println("pixel binary value is : "+random_Res);
		num5= Integer.parseInt(random_Res); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		return decimal2;
	}
	
	//getZoneRandomValueHidingPosition will give you red pixel value.
		public static int zoneOneRandomValueRetrievalProcess(String mainImagePath) throws Exception
		{
			int zoneOneRandomValue = 0;
			try
			{
				System.out.println("========================zone-1 Retrival==========================");
				BufferedImage img = null;
				img = DataHiding.readImage(mainImagePath);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
				
				// Red pixel value for Zone-1
				//In this red pixel value we will hide randomly selected value for zone-1
				int[] zoneOneRandompix_color = new int[4];
				for (int j = height/2; j <= height/2; j++) 
				{
					for (int i = width/2; i <= width/2; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneOneRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneOneRandomValue = zoneOneHiddenNum = RandomValueRetrieval.randomBitExtraction(zoneOneRandompix_color[0]); 
						System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOneRandompix_color[0]);
						System.out.println("Hidden Random Number in Zone-1 is : "+zoneOneHiddenNum);
						
					}
				}
				
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return zoneOneRandomValue;
		}
				
				
		//zone-2 random value hiding process
		public static int zoneTwoRandomValueRetrievalProcess(String stegnoImage1Path) throws Exception
		{
			int zoneTwoRandomValue = 0;
			try
			{
				System.out.println("========================zone-2 Retrival==========================");
				
				BufferedImage img = null;
				img = DataHiding.readImage(stegnoImage1Path);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
							
				// Red pixel value for Zone-2
				//In this red pixel value we will hide randomly selected value for zone-2
				int[] zoneTwoRandompix_color = new int[4];
				for (int j = (height/2)+1; j <= (height/2)+1; j++) 
				{
					for (int i = width/2; i <= width/2; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneTwoRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneTwoRandomValue = zoneTwoHiddenNum = RandomValueRetrieval.randomBitExtraction(zoneTwoRandompix_color[0]); 
						System.out.println("Zone-2 Red Color index ("+i+","+j+") value is : "+zoneTwoRandompix_color[0]);
						System.out.println("Hidden Random Number in Zone-2 is : "+zoneTwoHiddenNum);
						
					}
				}
					
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return zoneTwoRandomValue;
	     }
		

						
		//Zone-3 random value hiding Process		
		public static int zoneThreeRandomValueRetrievalProcess(String stegnoImage2Path) throws Exception
		{
			int zoneThreeRandomValue = 0;
			try
			{
				System.out.println("========================zone-3 Retrival==========================");
				BufferedImage img = null;
				img = DataHiding.readImage(stegnoImage2Path);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
				
				// Red pixel value for Zone-3
				//In this red pixel value we will hide randomly selected value for zone-3
				int[] zoneThreeRandompix_color = new int[4];
				for (int j = height/2; j <= height/2; j++) 
				{
					for (int i = (width/2)+1; i <= (width/2)+1; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneThreeRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneThreeRandomValue = zoneThreeHiddenNum = RandomValueRetrieval.randomBitExtraction(zoneThreeRandompix_color[0]); 
						System.out.println("Zone-3 Red Color index ("+i+","+j+") value is : "+zoneThreeRandompix_color[0]);
						System.out.println("Hidden Random Number in Zone-3 is : "+zoneThreeHiddenNum);
						
					}
				}
				
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return zoneThreeRandomValue;
		}
		
		//zone-4 random value hiding process
		public static int zoneFourRandomValueRetrievalProcess(String stegnoImage3Path) throws Exception
		{
			int zoneFourRandomValue = 0;
			try
			{
				System.out.println("========================zone-4 Retrival==========================");
				BufferedImage img = null;
				img = DataHiding.readImage(stegnoImage3Path);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
				
				// Red pixel value for Zone-4
				//In this red pixel value we will hide randomly selected value for zone-4
				int[] zoneFourRandompix_color = new int[4];
				for (int j = (height/2)+1; j <= (height/2)+1; j++) 
				{
					for (int i = (width/2)+1; i <= (width/2)+1; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneFourRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneFourRandomValue = zoneFourHiddenNum = RandomValueRetrieval.randomBitExtraction(zoneFourRandompix_color[0]); 
						System.out.println("Zone-4 Red Color index ("+i+","+j+") value is : "+zoneFourRandompix_color[0]);
						System.out.println("Hidden Random Number in Zone-4 is : "+zoneFourHiddenNum);
						
					}
				}	
				
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return zoneFourRandomValue;
		}

}
