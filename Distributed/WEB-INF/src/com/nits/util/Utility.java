/**
 * 
 */
package com.nits.util;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.imageio.ImageIO;

public class Utility
{
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Integer.parseInt(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	
	
	
	public static boolean convertFormat(String inputImagePath,
            String outputImagePath, String formatName) throws IOException {
        FileInputStream inputStream = new FileInputStream(inputImagePath);
        FileOutputStream outputStream = new FileOutputStream(outputImagePath);
         
        // reads input image from file
        BufferedImage inputImage = ImageIO.read(inputStream);
         
        // writes to the output image in specified format
        boolean result = ImageIO.write(inputImage, formatName, outputStream);
         
        // needs to close the streams
        outputStream.close();
        inputStream.close();
         
        return result;
    }

	
	
	
	
	
	public static String parse1(Object str) 
	{ 
		String p=""; 
		if(str==null) 
		{ 
			str=""; 
		} 
		else if(str.equals("")) 
		{ 
			str=""; 
		} 
		try
		{ 
			p=(String)str; 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse1(String str) "+e);
		} 
		return p; 
	}
	public static String getPro(String str) 
	{
		String pro="";
		try
		{
			java.security.ProtectionDomain pd =	Utility.class.getProtectionDomain();
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\Config.properties");
			property.load(in);
			pro=property.getProperty(str);
			//System.out.println("Property to return : "+pro);
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}
	public static Object parse2(Object str) 
	{ 
		Object obj=null;
		if(str!=null) 
			return str;
		else
			return obj; 
	}
	
	
	
	public static void processImage(String sec_Img, String enc_Sec_Img)
	{
		//System.out.println("sec_img_path:"+sec_Img);
		//System.out.println("enc_img_path:"+enc_Sec_Img);
		BufferedImage image = null;
		try {
			
		    image = ImageIO.read(new File(sec_Img));
		    
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        int[] a = new int[4];
        int xor;
        String type="Encrypt";
        
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	
            	a=getARGBPixelData(pixel);
            	xor=(i*j)%255;
            	if(type.equalsIgnoreCase("Encrypt"))
            	{
            		a[0]=makeBinary(a[0]) ^ makeBinary(xor);
            		a[1]=makeBinary(a[1]) ^ makeBinary(xor);
            		a[2]=makeBinary(a[2]) ^ makeBinary(xor);
            		a[3]=makeBinary(a[3]) ^ makeBinary(xor);
            	}
            	
            	wr1.setPixel(i, j, a);
            }
        }
        
        
        try {
           
           
            File outputfile = new File(enc_Sec_Img);
            ImageIO.write(I1, "bmp", outputfile);
        } 
        catch (IOException e) 
        {
          e.printStackTrace();  
          System.out.println("image is not saved");
        }
        
       
	}
	public static int makeBinary(int no)
	{
		String str=Integer.toBinaryString(no);
		String result="";
		if(str.length()<8)
		{
			String zero="";
			int how_many=8-str.length();
			for(int j=0;j<how_many;j++)
				zero+="0";
			result=zero+str;
		}
		else
		{
			result=str;
		}
		
		return Integer.parseInt(result,2);
	}
	
	

	public static int[] getARGBPixelData(int pixel)
	{
		int[] a = new int[4];
		try
		{
			int alpha = (pixel >> 24) & 0x000000FF;
			int red = (pixel >> 16) & 0x000000FF;
			int green = (pixel >>8 ) & 0x000000FF;
			int blue = (pixel) & 0x000000FF;
			a[0]=red;
        	a[1]=green;
        	a[2]=blue;
        	a[3]=alpha;
		}
		catch(Exception e)
		{
			System.out.println("Error is in ImageProcess getARGBPixelData(int pixel) "+e);
		}
		return a;
	}
	
	public static String processImageDecryption(String Ext_Enc_Sec_Img_path, String dec_Sec_Img_path)
	{
		//System.out.println("encryimag path :"+Ext_Enc_Sec_Img_path);
		
		//System.out.println("dec imag_path path :"+dec_Sec_Img_path);
		BufferedImage image = null;
		try {
		    image = ImageIO.read(new File(Ext_Enc_Sec_Img_path));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage I1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster wr1 = I1.getRaster();
        int[] a = new int[4];
        int xor;
        String type="Decrypt";
        
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++) 
            {
            	int pixel = image.getRGB(i, j);
            	
            	a=getARGBPixelData_1(pixel);
            	xor=(i*j)%255;
            	
            	if(type.equalsIgnoreCase("Decrypt"))
            	{
            		a[0]=makeBinary(a[0]) ^ makeBinary(xor);
            		a[1]=makeBinary(a[1]) ^ makeBinary(xor);
            		a[2]=makeBinary(a[2]) ^ makeBinary(xor);
            		a[3]=makeBinary(a[3]) ^ makeBinary(xor);
            	}
            	wr1.setPixel(i, j, a);
            }
        }
        try 
        {
            File outputfile = new File(dec_Sec_Img_path);
            ImageIO.write(I1, "jpg", outputfile);
            System.out.println("Decryption is successfull....");
        } 
        catch (IOException e) 
        {
          e.printStackTrace();  
          System.out.println("image is not saved");
        }
		return dec_Sec_Img_path;
	}
	public static int makeBinary_1(int no)
	{
		String str=Integer.toBinaryString(no);
		String result="";
		if(str.length()<8)
		{
			String zero="";
			int how_many=8-str.length();
			for(int j=0;j<how_many;j++)
				zero+="0";
			result=zero+str;
		}
		else
		{
			result=str;
		}
		
		return Integer.parseInt(result,2);
	}
	

	public static int[] getARGBPixelData_1(int pixel)
	{
		int[] a = new int[4];
		try
		{
			int alpha = (pixel >> 24) & 0x000000FF;
			int red = (pixel >> 16) & 0x000000FF;
			int green = (pixel >>8 ) & 0x000000FF;
			int blue = (pixel) & 0x000000FF;
			a[0]=red;
        	a[1]=green;
        	a[2]=blue;
        	a[3]=alpha;
		}
		catch(Exception e)
		{
			System.out.println("Error is in ImageProcess getARGBPixelData(int pixel) "+e);
		}
		return a;
	}
	
	public static void hideProcess(File bmpinfile,String bmpoutfile,byte intxt[]) throws Exception
	{
		try
		{
			FileInputStream inbmp=new FileInputStream(bmpinfile);
			FileOutputStream outbmpf=new FileOutputStream(bmpoutfile);
			DataOutputStream outbmp=new DataOutputStream(outbmpf);
			int norm_byte;
			int in_byte;
			int xor;
			int count=1;
			int in_size=intxt.length;
			int inb=0;
			int skip=0;
			System.out.println("Processing....");
			while((norm_byte=inbmp.read())!= -1)
			{
				if(count<55)
				{
					outbmp.write(norm_byte);
					//System.out.println("inside count<55 norm_byte value is : "+norm_byte);
				}
				if(count==55)
				{
					outbmp.writeInt(in_size);
					//System.out.println("in_size value in count==55 is : "+in_size);
					inbmp.skip(2);
					count=count+2;
				}
				if((count==59) || (count==60))
				{
					outbmp.write(norm_byte);
					//System.out.println("inside count==59 || count==60 norm_byte value is : "+norm_byte);
				}
				if (count > 60)  
				{
					
					if (count <(61 + 101 * in_size)) 
					{
						if(skip<100)
						{
							outbmp.write(norm_byte);
							//System.out.println("inside skip<100 norm_byte value is : "+norm_byte);
							skip++;						
						}
						else
						{							
							skip=0;
							in_byte=intxt[inb++];
							//System.out.println("in_byte value coming from array intxt : "+in_byte);
							xor=in_byte ^ 1;
							//System.out.println("xor value before hiding in image : "+xor);
							outbmp.write(xor);								
						}
					}
					else
					{
						outbmp.write(norm_byte);
					}
				}
				count++;
				//System.out.println("Count value is : "+count);
			}
			outbmp.flush();	
			inbmp.close();
			outbmp.close();
			outbmpf.close();
			System.out.println("Process Successfull.....!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static byte[] extractProcess(String bmpinfile) throws Exception
	{	
		byte bout[] = null;
		try
		{			
			FileInputStream in=new FileInputStream(bmpinfile);
			DataInputStream din=new DataInputStream(in);
			din.skip(54);
			int size=din.readInt();
			System.out.println("Size of hided image is :"+size);
			bout=new byte[size];
			int count=0;
			int insec_txt=0;
			din.skip(2);
			while(count < size)
			{
				din.skip(100);
				insec_txt=din.read();
				System.out.println("insec_txt value is : "+insec_txt);
				bout[count]=(byte)(insec_txt ^ 1);
				System.out.println("count value is : "+count);
				count++;		
			}		
			System.out.println("The byte length is  :"+bout.length);
			System.out.println(count+","+size+","+bout[0]+","+bout[1]+","+bout[2]+","+bout[3]+","+bout[4]);
			in.close();		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		return bout;
	}
	public static String getDate()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
			date = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDate( ): "+ e);
		}
		return date;
	}
	public static String getTime()
	{
		String time="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			time = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getTime( ): "+ e);
		}
		return time;
	}
	public static String getDay()
	{
		String day="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			int no=currentDate.get(Calendar.DAY_OF_WEEK);
			if(no==1)
				day="Sunday";
			else if(no==2)
				day="Monday";
			else if(no==3)
				day="TUESDAY";
			else if(no==4)
				day="WEDNESDAY";
			else if(no==5)
				day="THURSDAY";
			else if(no==6)
				day="FRIDAY";
			else if(no==7)
				day="SATURDAY";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	public static void main(String asdf[])
	{
		System.out.println(Utility.getPro("Driver"));
	}
}
