package com.nits.action.user;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HidingRandomValue 
{
	static String zoneOneRandomPixelBinaryNum ="";
	static String zoneOneRandom_P1 = "";
	static String zoneOneRandom_Res = "";
	static int zoneOneHidingNum = 0;
	static int zoneTwoHidingNum = 0;
	static int zoneThreeHidingNum = 0;
	static int zoneFourHidingNum = 0;
	
	static String zoneTwoRandomPixelBinaryNum ="";
	static String zoneTwoRandom_P1 = "";
	static String zoneTwoRandom_Res = "";
	
	static String zoneThreeRandomPixelBinaryNum ="";
	static String zoneThreeRandom_P1 = "";
	static String zoneThreeRandom_Res = "";
	
	static String zoneFourRandomPixelBinaryNum ="";
	static String zoneFourRandom_P1 = "";
	static String zoneFourRandom_Res = "";
	

	public static int zoneOneRandomBitAddition(int num, int zoneOneRandomNumber)
	{ 
		//adding six bit form pixel and two bit from secret message
		
		zoneOneRandomPixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
		zoneOneRandom_P1 = zoneOneRandomPixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
		
		int decimal2=0;
		int num5=0;
		int randomNumber = zoneOneRandomNumber;
		System.out.println("Random number for zone-1 is : "+randomNumber);
		String randomNumToBinary = DataHiding.getBinary1(randomNumber);
		String lastFourBitOfRandomNum = randomNumToBinary.substring(4);
		
		zoneOneRandom_Res = zoneOneRandom_P1 + ""+lastFourBitOfRandomNum; //adding 4 bit pixel and 4 bit random number bit
		System.out.println("Modified pixel binary value is : "+zoneOneRandom_Res);
		num5= Integer.parseInt(zoneOneRandom_Res); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		return decimal2;
	}
	
	public static int zoneTwoRandomBitAddition(int num, int zoneTwoRandomNumber)
	{ 
		//adding six bit form pixel and two bit from secret message
		
		zoneTwoRandomPixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
		zoneTwoRandom_P1 = zoneTwoRandomPixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
		
		int decimal2=0;
		int num5=0;
		int randomNumber = zoneTwoRandomNumber;
		System.out.println("Random number for zone-2 is : "+randomNumber);
		String randomNumToBinary = DataHiding.getBinary1(randomNumber);
		String lastFourBitOfRandomNum = randomNumToBinary.substring(4);
		
		zoneTwoRandom_Res = zoneTwoRandom_P1 + ""+lastFourBitOfRandomNum; //adding 4 bit pixel and 4 bit random number bit
		System.out.println("Modified pixel binary value is : "+zoneTwoRandom_Res);
		num5= Integer.parseInt(zoneTwoRandom_Res); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		return decimal2;
	}
	
	public static int zoneThreeRandomBitAddition(int num, int zoneThreeRandomNumber)
	{ 
		//adding six bit form pixel and two bit from secret message
		
		zoneThreeRandomPixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
		zoneThreeRandom_P1 = zoneThreeRandomPixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
		
		int decimal2=0;
		int num5=0;
		int randomNumber = zoneThreeRandomNumber;
		System.out.println("Random number for zone-3 is : "+randomNumber);
		String randomNumToBinary = DataHiding.getBinary1(randomNumber);
		String lastFourBitOfRandomNum = randomNumToBinary.substring(4);
		
		zoneThreeRandom_Res = zoneThreeRandom_P1 + ""+lastFourBitOfRandomNum; //adding 4 bit pixel and 4 bit random number bit
		System.out.println("Modified pixel binary value is : "+zoneThreeRandom_Res);
		num5= Integer.parseInt(zoneThreeRandom_Res); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		return decimal2;
	}
	
	public static int zoneFourRandomBitAddition(int num, int zoneFourRandomNumber)
	{ 
		//adding six bit form pixel and two bit from secret message
		
		zoneFourRandomPixelBinaryNum = DataHiding.getBinary1(num);//getting pixel value in binary
		zoneFourRandom_P1 = zoneFourRandomPixelBinaryNum.substring(0, 4);//taking four bit form pixel 8 bit
		
		int decimal2=0;
		int num5=0;
		int randomNumber = zoneFourRandomNumber;
		System.out.println("Random number for zone-4 is : "+randomNumber);
		String randomNumToBinary = DataHiding.getBinary1(randomNumber);
		String lastFourBitOfRandomNum = randomNumToBinary.substring(4);
		
		zoneFourRandom_Res = zoneFourRandom_P1 + ""+lastFourBitOfRandomNum; //adding 4 bit pixel and 4 bit random number bit
		System.out.println("Modified pixel binary value is : "+zoneFourRandom_Res);
		num5= Integer.parseInt(zoneFourRandom_Res); // after addition of bit, changing string to integer
		decimal2 = DataHiding.getDecimalFromBinary(num5);//changing binary to decimal and returning the decimal value
		return decimal2;
	}
	
	
	//getZoneRandomValueHidingPosition will give you red pixel value.
		public static int zoneOneRandomValueHidingProcess(String mainImagePath, String stegnoImage1Path, int zoneOneRandomNumber) throws Exception
		{
			
			System.out.println("=======================zone-1 started==============================");
			try
			{
				BufferedImage img = null;
				img = DataHiding.readImage(mainImagePath);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
				int m = 0;
				int n = 0;
				
				// Red pixel value for Zone-1
				//In this red pixel value we will hide randomly selected value for zone-1
				int[] zoneOneRandompix_color = new int[4];
				for (n = height/2; n <= height/2; n++) 
				{
					for (m = width/2; m <= width/2; m++) 
					{
						int pixel = img.getRGB(m, n);
						zoneOneRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneOneHidingNum = HidingRandomValue.zoneOneRandomBitAddition(zoneOneRandompix_color[0], zoneOneRandomNumber); 
						System.out.println("While Reading Zone-1 Red Color index ("+m+","+n+") value is : "+zoneOneRandompix_color[0]);
						
					}
				}
				
				int[] zoneOnePix_Color = new int[4];
				for (int j = 0; j < height; j++) 
				{
					for (int i = 0; i < width; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneOnePix_Color = DataHiding.getARGBPixelData(pixel);
						if((i==m-1) && (j==n-1))
						{
							System.out.println("While Writing Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
								
							Color newColor = new Color(zoneOneHidingNum, zoneOnePix_Color[1], zoneOnePix_Color[2]);
							System.out.println("zone-1 hinding number is : "+zoneOneHidingNum);
							img.setRGB(i, j, newColor.getRGB());
						}
						else
						{
						Color newColor = new Color(zoneOnePix_Color[0], zoneOnePix_Color[1], zoneOnePix_Color[2]);
						img.setRGB(i, j, newColor.getRGB());
						}
					}
				}	
				File ouptut = new File(stegnoImage1Path);
				ImageIO.write(img, "png", ouptut);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			return zoneOneRandomNumber;
		}
				
				
		//zone-2 random value hiding process
		public static void zoneTwoRandomValueHidingProcess(String stegnoImage1Path, String stegnoImage2Path, int zoneTwoRandomNumber) throws Exception
		{
			System.out.println("=======================zone-2 started==============================");
			try
			{
				
				BufferedImage img = null;
				img = DataHiding.readImage(stegnoImage1Path);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
				int m = 0;
				int n = 0;
							
				// Red pixel value for Zone-2
				//In this red pixel value we will hide randomly selected value for zone-2
				int[] zoneTwoRandompix_color = new int[4];
				for (n = (height/2)+1; n <= (height/2)+1; n++) 
				{
					for (m = width/2; m <= width/2; m++) 
					{
						int pixel = img.getRGB(m, n);
						zoneTwoRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneTwoHidingNum = HidingRandomValue.zoneTwoRandomBitAddition(zoneTwoRandompix_color[0], zoneTwoRandomNumber); 
						System.out.println("While reading Zone-2 Red Color index ("+m+","+n+") value is : "+zoneTwoRandompix_color[0]);
						
					}
				}
					
				int[] zoneTwoPix_Color = new int[4];
				for (int j = 0; j < height; j++) 
				{
					for (int i = 0; i < width; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneTwoPix_Color = DataHiding.getARGBPixelData(pixel);
						if((i==m-1) && (j==n-1))
						{
							System.out.println("While Writing Zone-2 Red Color index ("+i+","+j+") value is : "+zoneTwoPix_Color[0]);
											
							Color newColor = new Color(zoneTwoHidingNum, zoneTwoPix_Color[1], zoneTwoPix_Color[2]);
							System.out.println("zone-2 hinding number is : "+zoneTwoHidingNum);
							img.setRGB(i, j, newColor.getRGB());
						}
						else
						{
							Color newColor = new Color(zoneTwoPix_Color[0], zoneTwoPix_Color[1], zoneTwoPix_Color[2]);
							img.setRGB(i, j, newColor.getRGB());
						}
					}
				}	
				File ouptut = new File(stegnoImage2Path);
				ImageIO.write(img, "png", ouptut);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
						
		//Zone-3 random value hiding Process		
		public static void zoneThreeRandomValueHidingProcess(String stegnoImage2Path, String stegnoImage3Path, int zoneThreeRandomNumber) throws Exception
		{
			System.out.println("=======================zone-3 started==============================");
			try
			{
				BufferedImage img = null;
				img = DataHiding.readImage(stegnoImage2Path);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
				int m = 0;
				int n = 0;
				
				// Red pixel value for Zone-3
				//In this red pixel value we will hide randomly selected value for zone-3
				int[] zoneThreeRandompix_color = new int[4];
				for (n = height/2; n <= height/2; n++) 
				{
					for (m = (width/2)+1; m <= (width/2)+1; m++) 
					{
						int pixel = img.getRGB(m, n);
						zoneThreeRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneThreeHidingNum = HidingRandomValue.zoneThreeRandomBitAddition(zoneThreeRandompix_color[0], zoneThreeRandomNumber); 
						System.out.println("While reading Zone-3 Red Color index ("+m+","+n+") value is : "+zoneThreeRandompix_color[0]);
						
					}
				}
				
				int[] zoneThreePix_Color = new int[4];
				for (int j = 0; j < height; j++) 
				{
					for (int i = 0; i < width; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneThreePix_Color = DataHiding.getARGBPixelData(pixel);
						if((i==m-1) && (j==n-1))
						{
							System.out.println("While Writing Zone-3 Red Color index ("+i+","+j+") value is : "+zoneThreePix_Color[0]);
								
							Color newColor = new Color(zoneThreeHidingNum, zoneThreePix_Color[1], zoneThreePix_Color[2]);
							System.out.println("zone-3 hinding number is : "+zoneThreeHidingNum);
							img.setRGB(i, j, newColor.getRGB());
						}
						else
						{
						Color newColor = new Color(zoneThreePix_Color[0], zoneThreePix_Color[1], zoneThreePix_Color[2]);
						img.setRGB(i, j, newColor.getRGB());
						}
					}
				}	
				File ouptut = new File(stegnoImage3Path);
				ImageIO.write(img, "png", ouptut);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		//zone-4 random value hiding process
		public static void zoneFourRandomValueHidingProcess(String stegnoImage3Path, String stegnoImage4Path, int zoneFourRandomNumber) throws Exception
		{
			System.out.println("=======================zone-4 started==============================");
			try
			{
				BufferedImage img = null;
				img = DataHiding.readImage(stegnoImage3Path);
				int width = img.getWidth();
				int height = img.getHeight();
				System.out.println("Width of the image : "+width);
				System.out.println("Height of the image : "+height);
				int m = 0;
				int n = 0;
				
				// Red pixel value for Zone-4
				//In this red pixel value we will hide randomly selected value for zone-4
				int[] zoneFourRandompix_color = new int[4];
				for (n = (height/2)+1; n <= (height/2)+1; n++) 
				{
					for (m = (width/2)+1; m <= (width/2)+1; m++) 
					{
						int pixel = img.getRGB(m, n);
						zoneFourRandompix_color = DataHiding.getARGBPixelData(pixel);
						zoneFourHidingNum = HidingRandomValue.zoneFourRandomBitAddition(zoneFourRandompix_color[0], zoneFourRandomNumber); 
						System.out.println("While reading Zone-4 Red Color index ("+m+","+n+") value is : "+zoneFourRandompix_color[0]);
						
					}
				}	
				
				int[] zoneFourPix_Color = new int[4];
				for (int j = 0; j < height; j++) 
				{
					for (int i = 0; i < width; i++) 
					{
						int pixel = img.getRGB(i, j);
						zoneFourPix_Color = DataHiding.getARGBPixelData(pixel);
						if((i==m-1) && (j==n-1))
						{
							System.out.println("While Writing Zone-4 Red Color index ("+i+","+j+") value is : "+zoneFourPix_Color[0]);
								
							Color newColor = new Color(zoneFourHidingNum, zoneFourPix_Color[1], zoneFourPix_Color[2]);
							System.out.println("zone-4 hinding number is : "+zoneFourHidingNum);
							img.setRGB(i, j, newColor.getRGB());
						}
						else
						{
						Color newColor = new Color(zoneFourPix_Color[0], zoneFourPix_Color[1], zoneFourPix_Color[2]);
						img.setRGB(i, j, newColor.getRGB());
						}
					}
				}	
				File ouptut = new File(stegnoImage4Path);
				ImageIO.write(img, "png", ouptut);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
}
