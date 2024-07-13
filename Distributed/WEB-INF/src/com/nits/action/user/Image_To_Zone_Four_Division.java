package com.nits.action.user;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Image_To_Zone_Four_Division 
{
	public static byte[] image_To_Zone_Four_Division(String secretImagePath)
	{
		Path path = Paths.get(secretImagePath);
		byte[] content = null;
		try 
		{
			content = Files.readAllBytes(path);	
			System.out.println("Image Size =>"+content.length);
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//byte[] content = text.getBytes();	//storing string data in byte array
		
		int size = content.length;
		int rem = size%4;		// find out the reminder value
		
		System.out.println("Reminder value is :"+rem);
		System.out.println("size of byte array :"+size);
		
		int z1_size = size / 4 + 5;
		int z2_size = size / 4 + 5;
		int z3_size = size / 4 + 5;
		int z4_size = size / 4 + size % 4 + 5;
		
	// Convert following into a function
		String a = z1_size + "";
		int L = a.length();

		System.out.println("Len :" + z1_size);
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
		
		
		byte[] z1 = new byte[z1_size];
		byte[] z2 = new byte[z2_size];
		byte[] z3 = new byte[z3_size];
		byte[] z4 = new byte[z4_size];
		
		
		z1[0] = Byte.parseByte(a.substring(0, 1));
		z1[1] = Byte.parseByte(a.substring(1, 2));
		z1[2] = Byte.parseByte(a.substring(2, 3));
		z1[3] = Byte.parseByte(a.substring(3, 4));
		z1[4] = Byte.parseByte(a.substring(4, 5));
		
		z2[0] = z1[0];
		z2[1] = z1[1];
		z2[2] = z1[2];
		z2[3] = z1[3];
		z2[4] = z1[4];
		
		
		z3[0] = z1[0];
		z3[1] = z1[1];
		z3[2] = z1[2];
		z3[3] = z1[3];
		z3[4] = z1[4];
		
		String t = z4_size % 100 + "";
		
		z4[0] = z1[0];
		z4[1] = z1[1];
		z4[2] = z1[2];
		z4[3] = Byte.parseByte(t.substring(0, 1));
		z4[4] = Byte.parseByte(t.substring(1, 2));
		
		
		
		int c = 0;
		
		for(int i=5;i<z1_size;i++)
		{
			z1[i] = content[c++];
			z2[i] = content[c++];
			z3[i] = content[c++];
			z4[i] = content[c++];
			
		}
		
		for(int j=z1_size; j < (z1_size + size % 4);j++)
		{
				z4[j] = content[c++];
			
		}
		
		System.out.println("Zone 1 Size =>"+ z1.length);
		System.out.println("Zone 2 Size =>"+ z2.length);
		System.out.println("Zone 3 Size =>"+ z3.length);
		System.out.println("Zone 4 Size =>"+ z4.length);
	
		
		/*
		
		System.out.println("Byte 0 zone 1 =>"+ z4[0]+"");
		System.out.println("Byte 1 zone 1 =>"+ z4[1]+"");
		System.out.println("Byte 2 zone 1 =>"+ z4[2]+"");
		System.out.println("Byte 3 zone 1 =>"+ z4[3]+"");
		System.out.println("Byte 4 zone 1 =>"+ z4[4]+"");
		*/
		
		/*String loop_size = z1[0]+""+z1[1]+""+z1[2]+""+z1[3]+""+z1[4]+"";
		
		int loop_size1 = Integer.parseInt(loop_size);
		
	    loop_size = z4[0]+""+z4[1]+""+z4[2]+""+z4[3]+""+z4[4]+"";
		
		int loop_size2 = Integer.parseInt(loop_size);
		
		System.out.println(" loop size =>" + loop_size1);
		System.out.println(" loop size =>" + loop_size2);
		System.out.println(" total Image size " + (loop_size1 * 3 + loop_size2 -20 ) );
		
		int size1 = loop_size1 * 3 + loop_size2 -20;
		
		byte[] ext_content = new byte[size1];
		
		int k = 0;
		
		for(int i=5;i<loop_size1;i++)
		{
			ext_content[k++] = z1[i];
			ext_content[k++] = z2[i];
			ext_content[k++] = z3[i];
			ext_content[k++] = z4[i];
		}
		
		for(int j=loop_size1; j < loop_size2 ;j++)
		{
			ext_content[k++] = z4[j];	
			
			
		}
		
		System.out.println("Extracted Image Size =>"+ ext_content.length);
		
		String zoneBasedData = "Hello";*/
		
		return z4;
    }	
}
