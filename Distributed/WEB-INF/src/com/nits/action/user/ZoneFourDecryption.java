package com.nits.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ZoneFourDecryption 
{
	static ArrayList<Integer>zoneFourtotalPix = new ArrayList<Integer>();
	
	static ArrayList<String> zoneFourtotalPix5 = new ArrayList<String>();
	static ArrayList<String> zoneFourtotalPix2 = new ArrayList<String>();
	static ArrayList<String> zoneFourtotalPix3 = new ArrayList<String>();
	static ArrayList<String> zoneFoursec = new ArrayList<String>();
	static ArrayList<String> zoneFoursec2 = new ArrayList<String>();
	static ArrayList<String> zoneFourExtBit = new ArrayList<String>();
	
	static int zoneFourmax = 0;
	static int zoneFourcount = 0;
	
	
	static int zoneFourMsgLength5 = 0;
	static int zoneFoursecretMsgLength = 0;
	static int zoneFourCount = 0;
	static ArrayList<String> ZoneFourExtValue = new ArrayList<String>();
	
	public static void zoneFourDecryptionProcess(String stegnoImage8Path, int zoneFourRandomNumber)
	{
		int zoneFourHide_pix_count = 0;
		zoneFourtotalPix.clear();
		zoneFourtotalPix5.clear();
		zoneFourtotalPix2.clear();
		zoneFourtotalPix3.clear();
		zoneFoursec.clear();
		zoneFoursec2.clear();
		zoneFourExtBit.clear();
		ZoneFourExtValue.clear();
		
		BufferedImage img = null;
		img = ZoneFourDecryption.readImage(stegnoImage8Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Zone-4 Width of the image : "+width);
		System.out.println("Zone-4 Height of the image : "+height);
		
		//Zone-4 hiding position values.
		
			int[] zoneFourPix_Color2 = new int[4];
			for (int j = (height/2)+2; j < height; j++) 
			{
				for (int i = (width/2)+1; i < width; i++) 
				{
					
					if((i % zoneFourRandomNumber == 0)&&(zoneFourHide_pix_count < 10) )
					{
						int pixel = img.getRGB(i, j);
						zoneFourPix_Color2 = ZoneFourDecryption.getARGBPixelData(pixel);
						//System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
						ZoneFourDecryption.getSecretMsg(zoneFourPix_Color2[0]);
						//System.out.println("Taking pixel for decryption in zone-4 is : "+zoneFourPix_Color2[0]);
						zoneFourHide_pix_count++;
					}
				}
			}
		
	}
	
	
	public static void zoneFourDecryptionProcess2(String stegnoImage8Path, int secLength, int zoneFourRandomNumber)
	{
		int zoneFourhide_pix_count2 = 0;
		System.out.println("zone-4 process 2 started");
		BufferedImage img = null;
		img = ZoneFourDecryption.readImage(stegnoImage8Path);
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println("Zone-4 Width of the image : "+width);
		System.out.println("Zone-4 Height of the image : "+height);
		
		//Zone-4 decryption process...
		
			int[] zoneFourPix_Color = new int[4];
			for (int j = (height/2)+2; j < height; j++) 
			{
				for (int i = (width/2)+1; i < width; i++) 
				{
					
					if(i % zoneFourRandomNumber == 0)
					{
						int pixel = img.getRGB(i, j);
						zoneFourPix_Color = ZoneFourDecryption.getARGBPixelData(pixel);
						
						zoneFourhide_pix_count2++;
						if(zoneFourhide_pix_count2<=secLength) 
						{
							//System.out.println("secret message pixel value is : "+zoneFourPix_Color[0]);
							ZoneFourDecryption.getSecretMsg4(zoneFourPix_Color[0]);
							
							
						}
						
						//System.out.println("Zone-1 Red Color index ("+i+","+j+") value is : "+zoneOnePix_Color[0]);
					}
				}
			}
		
	}
	
	
	public static String getSecretMsg(int pix)
	{
		//getting pixel from zone-4
		
		int []secBit = new int[10000];
		ZoneFourDecryption.zoneFourtotalPix.add(pix);
		String pixelBinaryNum = ZoneFourDecryption.getBinary1(pix);
		String p2 = pixelBinaryNum.substring(4);
		zoneFourtotalPix2.add(p2); //4 bit of pixel value storing in array list
		return zoneFourtotalPix2.toString();
	}
	
	public static String getSecretMsg4(int pix)
	{
		//System.out.println("Zone-4 getSecretMsg4 started...");
		//getting pixel of zone-4
		
		String pixelBinaryNum = ZoneFourDecryption.getBinary1(pix);
		// taking starting 4 bit from 8 bit of pixel
		String p2 = pixelBinaryNum.substring(4);
		zoneFourtotalPix5.add(p2);
		
		return zoneFourtotalPix5.toString();
	}
	
	public static void getSecretMsg2()
	{
		String str5 = "";
		ZoneFourDecryption.zoneFourtotalPix3.clear();
		
		int i3=0;
		ZoneFourDecryption.zoneFourtotalPix3 = (ArrayList<String>) ZoneFourDecryption.zoneFourtotalPix2;
		//String []list4 = new String[Decryption.totalPix3.size()];
		ArrayList<String> al = new ArrayList<String>();
		//String []list5 = new String[list4.length];
		for(int i11=0;i11<ZoneFourDecryption.zoneFourtotalPix3.size();i11++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(ZoneFourDecryption.zoneFourtotalPix3.get(i11));
			//System.out.println("al data in zone-4 is : "+al.get(i11));
		}
		for(i3=0;i3<10;i3++)
		{
			str5+= al.get(i3);
			
		}
		int len = str5.length();
		//System.out.println("str 5 length in zone-4 is : "+str5);
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			zoneFoursec.add(str3);
			str3="";
		}
		String ss="";
		String secLen = "";
		char c=0;
		for(String p :zoneFoursec)
		{
			int num1 = ZoneFourDecryption.Binary2ASCII(p);
			secLen += num1;
		}
		try
		{
			zoneFourMsgLength5 = Integer.parseInt(secLen.trim());
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
		ZoneFourDecryption.zoneFourtotalPix3.clear();
		int i3=0;
		ZoneFourDecryption.zoneFourtotalPix3 = (ArrayList<String>) ZoneFourDecryption.zoneFourtotalPix5;
		//System.out.println("Zone-4 getSecretMsg5 started");
		//String []list4 = new String[Decryption.totalPix3.size()];
		//String []list5 = new String[list4.length];
		ArrayList<String> al = new ArrayList<String>();
		//al.clear();
		
		for(int i11=0;i11<ZoneFourDecryption.zoneFourtotalPix3.size();i11++)
		{
			//list4[i11]= totalPix3.get(i11);
			al.add(ZoneFourDecryption.zoneFourtotalPix3.get(i11));
			//System.out.println("ZoneFourDecryption.zoneFourtotalPix3.get(i11) is : "+ZoneFourDecryption.zoneFourtotalPix3.get(i11));
		}
		for(i3=0;i3<ZoneFourDecryption.zoneFourMsgLength5*2;i3++)
		{
			str5+= al.get(i3);
			//System.out.println("Secret message bit in zone-4 is : "+al.get(i3));
		}
		//System.out.println("Complete Secret message of Zone-4 in binary is : "+str5);
		int len = str5.length();
		String str3="";
		for(int i=0;i<len;i=i+8)
		{
			for(int j=i;j<i+8;j++)
			{
			 char c= str5.charAt(j);
				str3 += c;
			}
			zoneFoursec2.add(str3);
			//System.out.println("Zone-4 Secret message letter binary value is : "+str3);
			String resNum = ZoneFourDecryption.binaryToDecimal(str3);
			ZoneFourExtValue.add(resNum);
			
			
			/*int cnum = Integer.parseInt(str3);
			int resNum = ZoneOneDecryption.getDecimalFromBinary(cnum);
			System.out.println("extracted binary number is : "+str3);*/
			//System.out.println("extracted number is : "+resNum);
			
			str3="";
		}
		
		return null;
	}
	
	public static String getSecretMsg()
	{
		String secret = ZoneFourDecryption.getSecretMsg5();
		
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
		System.out.println("Reading image in Zone-4 is : "+fileLocation);
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
		  		//System.out.println("Zone-4 Secret message letter Decimal value is : "+i);
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
	
	public static String binaryToDecimal(String s){
        int degree = 1;
        int n = 0;
        for (int k=s.length()-1; k>=0; k--){
            n += degree * (s.charAt(k) - '0');
            degree *= 2;
        }
        return n + "";
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
