package ocjp_MyExamples;


/* This program shows why BufferedStream is much more efficient than just a data Stream in java.
 * Buffered Stream reads and writes chunks of data to and from the buffer resulting in far more efficient file access than a Unbuffered stream.
 */



import java.io.*;

public class StreamVsBufferedStream 
{
	public static void main(String args[])throws IOException
	{
		File source=new File("C:\\Users\\arpan\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\InputStreamVsBufferedInputStream_SourceFile.txt");
		
		File target=new File("C:\\Users\\arpan\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\InputStreamVsBufferedInputStream_TargetFile.txt");
				
		
			long time=FileCopyUsingStream(source,target);
			
			
			System.out.println("Using only Stream took "+time+" milli seconds to read and write from source to target file");
			
			time=FileCopyUsingBufferedStream(source,target);
			
			System.out.println("Using Buffered Stream took "+time+" milli seconds to read and write from source to target file");
			
			time=FileCopyUsingBufferedStreamAndByteArray(source,target);
			
			System.out.println("Using Buffered Stream and a Byte array as buffer took "+time+" milli seconds to read and write from source to target file");
		
		
	}
	
	static long FileCopyUsingStream(File source,File target)throws IOException
	{
		long time=java.lang.System.currentTimeMillis();
		if(target.exists())
		{
			try(InputStream in=new FileInputStream(source); OutputStream out=new FileOutputStream(target)) // This is try with resources and will automatically close the file resources 
			{																					           // opened after use when the try block ends.
				int b;
				while((b=in.read())!=-1)
				{
					out.write(b);
				}
			}
		}
		else
		{
			System.out.println("The source File doesnt exists !");
		}
		return java.lang.System.currentTimeMillis()-time;
	}
	
	static long FileCopyUsingBufferedStream(File source,File target)throws IOException
	{
		long time=java.lang.System.currentTimeMillis();
		if(source.exists())
		{
			try(InputStream in=new BufferedInputStream(new FileInputStream(source)); OutputStream out=new BufferedOutputStream(new FileOutputStream(target)))
			{
				int b;
				while((b=in.read())!=-1)
				{
					out.write(b);
				}
			}
		}
		else
		{
			System.out.println("The source File doesnt exists !");
		}
		return java.lang.System.currentTimeMillis()-time;
	}
	
	
	static long FileCopyUsingBufferedStreamAndByteArray(File source,File target)throws IOException
	{
		long time=java.lang.System.currentTimeMillis();
		
		byte buffer[]=new byte[1024]; // declaring a buffer of size 1 kilo byte
		
		
		if(source.exists())
		{
			try(InputStream in=new BufferedInputStream(new FileInputStream(source)); OutputStream out=new BufferedOutputStream(new FileOutputStream(target)))
			{
				while((in.read(buffer))!=-1)
				{
					out.write(buffer);
				}
			}
		}
		else
		{
			System.out.println("The source File doesnt exists !");
		}
		return java.lang.System.currentTimeMillis()-time;
	}
	
	
}
