package com.nits.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ZoneTwoDecryption 
{
	static ArrayList<Integer>zoneTwototalPix = new ArrayList<Integer>();
	
	static ArrayList<String> zoneTwototalPix5 = new ArrayList<String>();
	
	
	
	
	
	static int zoneTwoMsgLength5 = 0;
	static int zoneTwosecretMsgLength = 0;
	static int zoneTwoCount = 0;
	static ArrayList<String> ZoneTwoExtValue = new ArrayList<String>();
	
	public static ArrayList<String> zoneTwoDecryptionProcess(String stegnoImage8Path, int zoneTwoRandomNumber)
	{
		zoneTwototalPix5.clear();
		ZoneTwoExtValue.clear();
		int zoneTwoHide_pix_count = 0;
		ArrayList<String> zoneTwototalPix2 = new ArrayList<String>();
		ArrayList<String> zoneOnetotalPix11 = new ArrayList<String>();
		
		BufferedImage img = null;
		img = ZoneTwoDecryption.readImage(stegnoImage8Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Zone-2 Width of the image : "+width);
		System.out.println("Zone-2 Height of the image : "+height);
		
		//Zone-2 decryption process...
		
			int[] zoneTwoPix_Color2 = new int[4];
			for (int j = 0; j < height/2; j++) 
			{
				for (int i = (width/2)+1; i < width; i++) 
				{
					int pixel = img.getRGB(i, j);
					zoneTwoPix_Color2 = ZoneTwoDecryption.getARGBPixelData(pixel);
					if((i % zoneTwoRandomNumber == 0)&&(zoneTwoHide_pix_count < 10) )
					{
						//System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
						zoneTwototalPix2 = ZoneTwoDecryption.getSecretMsg(zoneTwoPix_Color2[0]);
						zoneOnetotalPix11.addAll(zoneTwototalPix2);
						//System.out.println("taking pixel for decryption in zone-2 : "+zoneTwoPix_Color2[0]);
						zoneTwoHide_pix_count++;
					}
				}
			}
			return zoneOnetotalPix11;
		
	}
	
	
	public static void zoneTwoDecryptionProcess2(String stegnoImage8Path, int secLength, int zoneTwoRandomNumber)
	{
		int zoneTwohide_pix_count2 = 0;
		//System.out.println("zone-2 process 2 started");
		BufferedImage img = null;
		img = ZoneTwoDecryption.readImage(stegnoImage8Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Zone-2 Width of the image : "+width);
		System.out.println("Zone-2 Height of the image : "+height);
		
		//Zone-2 decryption process...
		
			int[] zoneTwoPix_Color = new int[4];
			for (int j = 0; j < height/2; j++) 
			{
				for (int i = (width/2)+1; i < width; i++) 
				{
					int pixel = img.getRGB(i, j);
					zoneTwoPix_Color = ZoneTwoDecryption.getARGBPixelData(pixel);
					if(i % zoneTwoRandomNumber == 0)
					{
						
						zoneTwohide_pix_count2++;
						if (zoneTwohide_pix_count2<=secLength)
						{
							//System.out.println("secret message pixel value in zone-2 is : "+zoneTwoPix_Color[0]);
							ZoneTwoDecryption.getSecretMsg4(zoneTwoPix_Color[0]);
							
							
						}
						
						//System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
					}
				}
			}
		
	}
	
	
	public static ArrayList<String> getSecretMsg(int pix)
	{
		//getting pixel from zone-2
		ArrayList<String> zoneTwototalPix2 = new ArrayList<String>();
		
		ZoneTwoDecryption.zoneTwototalPix.add(pix);
		String pixelBinaryNum = ZoneTwoDecryption.getBinary1(pix);
		String p2 = pixelBinaryNum.substring(4);
		zoneTwototalPix2.add(p2); //4 bit of pixel value storing in array list
		return zoneTwototalPix2;
	}
	
	public static String getSecretMsg4(int pix)
	{
		//System.out.println("getSecretMsg4 zone-2 started...");
		//getting pixel value form zone-2
		
		String pixelBinaryNum = ZoneTwoDecryption.getBinary1(pix);
		// taking starting 4 bit from 8 bit of pixel
		String p2 = pixelBinaryNum.substring(4);
		zoneTwototalPix5.add(p2);
		
		return zoneTwototalPix5.toString();
	}
	
	public static void getSecretMsg2(ArrayList<String> zoneTwototalPix2)
	{
		ArrayList<String> zoneTwosec = new ArrayList<String>();
		String str5 = "";
		
		//String []list4 = new String[Decryption.totalPix3.size()];
		ArrayList<String> al = new ArrayList<String>();
		//String []list5 = new String[list4.length];
		for(int i = 0; i<zoneTwototalPix2.size(); i++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(zoneTwototalPix2.get(i));
			//System.out.println("al data in zone-2 is : "+al.get(i11));
		}
		for(int i = 0; i<10; i++)
		{
			str5+= al.get(i);
			
		}
		int len = str5.length();
		//System.out.println("str 5 length in zone-2 is : "+str5);
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			zoneTwosec.add(str3);
			
			str3="";
		}
		String ss="";
		String secLen = "";
		char c=0;
		for(String p :zoneTwosec)
		{
			int num1 = ZoneTwoDecryption.Binary2ASCII(p);
			secLen += num1;
		}
		try
		{
			zoneTwoMsgLength5 = Integer.parseInt(secLen.trim());
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
		}
		System.out.println();
	}
	
	
	public static ArrayList<String> getSecretMsg5()
	{
		String str5="";
		int i3=0;
		System.out.println("zoneTwototalPix5 size in  getSecretMsg5 : "+ZoneTwoDecryption.zoneTwototalPix5.size());
		//System.out.println("getSecretMsg5 in zone-2 started");
		//String []list4 = new String[Decryption.totalPix3.size()];
		//String []list5 = new String[list4.length];
		ArrayList<String> al = new ArrayList<String>();
		//al.clear();
		
		for(int i11=0;i11<ZoneTwoDecryption.zoneTwototalPix5.size();i11++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(ZoneTwoDecryption.zoneTwototalPix5.get(i11));
			//System.out.println("ZoneTwoDecryption.zoneTwototalPix3.get(i11) is : "+ZoneTwoDecryption.zoneTwototalPix3.get(i11));
		}
		for(i3=0;i3<ZoneTwoDecryption.zoneTwoMsgLength5*2;i3++)
		{
			str5+= al.get(i3);
			//System.out.println("Secret message bit in zone-2 is : "+al.get(i3));
		}
		System.out.println("Complete Secret message of zone-2 in binary is : "+str5);
		int len = str5.length();
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			String resNum = ZoneTwoDecryption.binaryToDecimal(str3);
			ZoneTwoExtValue.add(resNum);
			str3="";
		}
		
		return ZoneTwoExtValue;
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
		System.out.println("Reading image in zone-2 : "+fileLocation);
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
		  		//System.out.println("Secret message letter Decimal value in zone-2 is : "+i);
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
	
	public static String binaryToDecimal(String s){
        int degree = 1;
        int n = 0;
        for (int k=s.length()-1; k>=0; k--){
            n += degree * (s.charAt(k) - '0');
            degree *= 2;
        }
        return n + "";
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
}
