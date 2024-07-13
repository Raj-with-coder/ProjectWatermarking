package com.nits.action.user;

import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;



public class DataHiding 
{
	//get RandomNumber method will give you number randomly between 2 to 7
	public static int getRandomNumber()
	{
		int randomNum;
		int minimum = 2;
		int maximum = 7;
		randomNum = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		return randomNum;
	}
	
	public static String getStringLength(int Len) 
	{
		String a = Len + "";
		int L = a.length();

		System.out.println("Len :" + Len);
		if (L == 1) 
		{
			a = "0000" + a;
		}
		else if (L == 2) 
		{
			a = "000" + a;
		}
		else if (L == 3) 
		{
			a = "00" + a;
		}
		else if (L == 4) 
		{
			a = "0" + a;
		}
		return a;
	}
	
	
	public static int getDecimalFromBinary(int binary)
	{
		// this method is used to get decimal value from binary values
        int decimal = 0;
        int power = 0;
        while(true)
        {
            if(binary == 0)
            {
                break;
            } 
            else 
            {
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
		// changing every string alphabet to 8 bit binary 
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
		// changing integer value to 8 bit binary
		
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
		int len = str.length();
		if(len>8)
		{
			str = str.substring(24);
		}
		return str;
	}
	
	// GetARGBPixelData Method will take pixel value as input and give you values of red, green, blue and alpha.
	public static int[] getARGBPixelData(int pixel) 
	{
		int []a = new int[4];
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
	
	// readImage method will take image file path as input and return a buffered image.
	public static BufferedImage readImage(String fileLocation)
	{
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
}
