package com.nits.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class ZoneOneDecryption 
{
	static ArrayList<String> zoneOnetotalPix5 = new ArrayList<String>();
	static int zoneOnemax = 0;
	static int zoneOnecount = 0;
	static int zoneOneMsgLength5 = 0;
	static int zoneOnesecretMsgLength = 0;
	static int zoneOneCount = 0;
	static ArrayList<String> ZoneOneExtValue = new ArrayList<String>();
	
	public static ArrayList<String> zoneOneDecryptionProcess(String stegnoImage8Path, int zoneOneRandomNumber)
	{
		zoneOnetotalPix5.clear();
		ZoneOneExtValue.clear();
		int zoneOneHide_pix_count = 0;
		ArrayList<String> zoneOnetotalPix2 = new ArrayList<String>();
		ArrayList<String> zoneOnetotalPix11 = new ArrayList<String>();
		System.out.println("inside zone one-1");
		BufferedImage img = null;
		img = ZoneOneDecryption.readImage(stegnoImage8Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("inside zone one-2");
		System.out.println("Zone-1 Width of the image : "+width);
		System.out.println("Zone-1 Height of the image : "+height);
		System.out.println("inside zone one-3");
		//Zone-1 hiding position values.
		
			int[] zoneOnePix_Color2 = new int[4];
			System.out.println("inside zone one-4 and random number: " + zoneOneRandomNumber);
			for (int j = 0; j < height/2; j++) 
			{
				
				for (int i = 0; i < width/2; i++) 
				{
					
					int pixel = img.getRGB(i, j);
					
					
					
					zoneOnePix_Color2 = ZoneOneDecryption.getARGBPixelData(pixel);
					
					if((i % zoneOneRandomNumber == 0)&&(zoneOneHide_pix_count < 10) )
					{
						System.out.println("inside zone one-5");
						//System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
						zoneOnetotalPix2 = ZoneOneDecryption.getSecretMsg(zoneOnePix_Color2[0]);
						zoneOnetotalPix11.addAll(zoneOnetotalPix2);
						System.out.println("taking pixel for decryption : "+zoneOnePix_Color2[0]);
						System.out.println("zoneOneHide_pix_count value is : "+zoneOneHide_pix_count);
						zoneOneHide_pix_count++;
					}
					
				}
			}
			return zoneOnetotalPix11;
		
	}
	
	
	public static void zoneOneDecryptionProcess2(String stegnoImage8Path, int secLength, int zoneOneRandomNumber)
	{
		int zoneOnehide_pix_count2 = 0;
		System.out.println("zone-1 process 2 started");
		BufferedImage img = null;
		img = ZoneOneDecryption.readImage(stegnoImage8Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Zone-1 Width of the image : "+width);
		System.out.println("Zone-1 Height of the image : "+height);
		
		//Zone-1 decryption process...
		
			int[] zoneOnePix_Color = new int[4];
			for (int j = 0; j < height/2; j++) 
			{
				for (int i = 0; i < width/2; i++) 
				{
					int pixel = img.getRGB(i, j);
					zoneOnePix_Color = ZoneOneDecryption.getARGBPixelData(pixel);
					if(i % zoneOneRandomNumber == 0)
					{
						
						zoneOnehide_pix_count2++;
						if ((zoneOnehide_pix_count2<=secLength)) 
						{
							//System.out.println("zoneOnehide_pix_count2 value is : "+zoneOnehide_pix_count2);
							//System.out.println("secret message pixel value is : "+zoneOnePix_Color[0]);
							ZoneOneDecryption.getSecretMsg4(zoneOnePix_Color[0]);
							
							
						}
						
						//System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
					}
				}
			}
		
	}
	
	
	public static ArrayList<String> getSecretMsg(int pix)
	{
		ArrayList<String> zoneOnetotalPix2 = new ArrayList<String>();
		//getting pixel whose value is equal to the max histogram value
		
		String pixelBinaryNum = ZoneOneDecryption.getBinary1(pix);
		String p2 = pixelBinaryNum.substring(4);
		zoneOnetotalPix2.add(p2); //4 bit of pixel value storing in array list
		return zoneOnetotalPix2;
	}
	
	public static String getSecretMsg4(int pix)
	{
		//System.out.println("getSecretMsg4 started...");
		//getting pixel whose value is equal to the max histogram value
		String pixelBinaryNum = ZoneOneDecryption.getBinary1(pix);
		// taking starting 4 bit from 8 bit of pixel
		String p2 = pixelBinaryNum.substring(4);
		zoneOnetotalPix5.add(p2);
		
		//System.out.println("zoneOnetotalPix5 size is : "+zoneOnetotalPix5.size());
		
		return zoneOnetotalPix5.toString();
	}
	
	public static void getSecretMsg2(ArrayList<String> zoneOnetotalPix2)
	{
		ArrayList<String> zoneOnesec = new ArrayList<String>();
		String str5 = "";
		//ZoneOneDecryption.zoneOnetotalPix3.clear();
		
		System.out.println("zoneOnetotalPix2 size is : "+zoneOnetotalPix2.size());
		
		//String []list4 = new String[Decryption.totalPix3.size()];
		ArrayList<String> al = new ArrayList<String>();
		//String []list5 = new String[list4.length];
		for(int i=0;i<zoneOnetotalPix2.size();i++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(zoneOnetotalPix2.get(i));
			System.out.println("al data is : "+al.get(i));
		}
		for(int i = 0; i< 10; i++)
		{
			str5+= al.get(i);
			
		}
		int len = str5.length();
		System.out.println("str 5 length is : "+str5);
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			System.out.println("str3 value is : "+str3);
			zoneOnesec.add(str3);
			str3="";
		}
		
		System.out.println("value in zoneOneSec : "+zoneOnesec);
		
		
		String ss="";
		String secLen = "";
		char c=0;
		for(String p :zoneOnesec)
		{
			int num1 = ZoneOneDecryption.Binary2ASCII(p);
			secLen += num1;
		}
		try
		{
			zoneOneMsgLength5 = Integer.parseInt(secLen.trim());
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
		}
		System.out.println();
	}
	
	
	public static String getSecretMsg5()
	{
		String str5="";
		
		//System.out.println("getSecretMsg5 started");
		//String []list4 = new String[Decryption.totalPix3.size()];
		//String []list5 = new String[list4.length];
		ArrayList<String> al = new ArrayList<String>();
		al.clear();
		
		for(int i = 0; i < ZoneOneDecryption.zoneOnetotalPix5.size(); i++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(ZoneOneDecryption.zoneOnetotalPix5.get(i));
			//System.out.println("ZoneOneDecryption.zoneOnetotalPix3.get(i11) is : "+ZoneOneDecryption.zoneOnetotalPix3.get(i11));
		}
		for(int i = 0; i<ZoneOneDecryption.zoneOneMsgLength5*2; i++)
		{
			str5+= al.get(i);
			//System.out.println("Secret message bit is : "+al.get(i3));
		}
		//System.out.println("Complete Secret message in binary is : "+str5);
		int len = str5.length();
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			String resNum = ZoneOneDecryption.binaryToDecimal(str3);
			ZoneOneExtValue.add(resNum);
			str3="";
		}
		return null;
	}
	
	public static String getSecretMsg()
	{
		String secret = ZoneOneDecryption.getSecretMsg5();
		
		return secret;
		
	}
	
	public static String BinaryToHex(String hex)
	{
		  long num = Long.parseLong(hex);
		  long rem;
		  while(num > 0)
		  {
			  rem = num % 10;
			  num = num / 10;
			  if(rem != 0 && rem != 1)
			  {
				  System.out.println("This is not a binary number.");
				  System.out.println("Please try once again.");
				  System.exit(0);
			  }
		  }
		  int i= Integer.parseInt(hex,2);
		  String hexString = Integer.toHexString(i);
		  return hexString;
	}
	
	public static BufferedImage readImage(String fileLocation)
	{
		System.out.println("file location is : "+fileLocation);
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File(fileLocation));
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return img;
    }
	
	public static int Binary2ASCII(String str) 
	{
		  long num = Long.parseLong(str);
		  long rem;
		  while(num > 0)
		  {
			  rem = num % 10;
			  num = num / 10;
			  if(rem != 0 && rem != 1)
			  {
				  System.out.println("This is not a binary number.");
				  System.out.println("Please try once again.");
				  System.exit(0);
			  }
		  }
		  		int i= Integer.parseInt(str,2);
		  		//System.out.println("Secret message letter Decimal value is : "+i);
		  		return i;
	}
	
	public static int getDecimalFromBinary(int binary)
	{
        int decimal = 0;
        int power = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        return decimal;
    }
	
	public static String[] getBinary(String str) 
	{
		String a[] = new String[str.length()];
		for (int i = 0; i < str.length(); i++) 
		{
			char c = str.charAt(i);
			a[i] = Integer.toBinaryString(c);
			if (a[i].length() == 0 || a[i].length() == 1 || a[i].length() == 2
					|| a[i].length() == 3 || a[i].length() == 4
					|| a[i].length() == 5 || a[i].length() == 6
					|| a[i].length() == 7) 
			{
				String zero = "";
				int how_many = 8 - a[i].length();
				for (int j = 0; j < how_many; j++)
					zero += "0";
				a[i] = zero + a[i];
			}
		}
		return a;
	}

	public static String getBinary1(int no) 
	{
		String str = Integer.toBinaryString(no);
		for (int i = 0; i < str.length(); i++) 
		{
			if (str.length() == 0 || str.length() == 1 || str.length() == 2
					|| str.length() == 3 || str.length() == 4
					|| str.length() == 5 || str.length() == 6
					|| str.length() == 7) 
			{
				String zero = "";
				int how_many = 8 - str.length();
				for (int j = 0; j < how_many; j++)
					zero += "0";
				str = zero + str;
			}
		}
		return str;
	}
	
	public static int[] getARGBPixelData(int pixel) 
	{
		int[] a = new int[4];
		try 
		{
			int alpha = (pixel >> 24) & 0x000000FF;
			int red = (pixel >> 16) & 0x000000FF;
			int green = (pixel >> 8) & 0x000000FF;
			int blue = (pixel) & 0x000000FF;
			a[0] = red;
			a[1] = green;
			a[2] = blue;
			a[3] = alpha;

		} 
		catch (Exception e) 
		{
			System.out.println("Error is in ImageProcess getARGBPixelData(int pixel) "+ e);
		}
		return a;
	}
	
	public static String binaryToDecimal(String s){
        int degree = 1;
        int n = 0;
        for (int k=s.length()-1; k>=0; k--){
            n += degree * (s.charAt(k) - '0');
            degree *= 2;
        }
        return n + "";
    }
	
	public static int getDecimalFromBinary2(String binary)
	{
		//binary = Integer.toBinaryString(-1);
		long l = Long.parseLong(binary, 2);
		int i = (int) l;
        return i;
    }
	

}
