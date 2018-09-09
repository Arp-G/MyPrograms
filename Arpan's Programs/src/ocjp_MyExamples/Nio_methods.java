package ocjp_MyExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;




public class Nio_methods 
{
	public static void main(String args[])throws IOException, java.net.URISyntaxException
	{
		Using_Path_Interface_Methods();
		
		//Using_Files_Class_Methods();
		
		//Using_NIO_Stream();
	}
	
	
	static void Using_Path_Interface_Methods() throws IOException , java.net.URISyntaxException
	{
		Path path1=Paths.get("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\nio Example Resource\\test.txt"); //This file exists
		
		Path path2=Paths.get("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\nio Example Resource\\test1.txt"); //This file does not exists
		
		Path dir=Paths.get("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\nio Example Resource\\dir"); //This is a Directory which exists
		
		Path dir2=FileSystems.getDefault().getPath("C:\\Users\\arpan\\Documents\\eclipse-workspace\\Arpan's Programs\\src\\ocjp_MyExamples\\Resources\\nio Example Resource\\dir"); //This is another way to obtain Path ... this directory does not exists
		
		Path rel=Paths.get("rel\\dir\\fixious.txt"); //This is a relative path
		
		Path usingUri=Paths.get(new java.net.URI("file:///tmp.txt//yoyo"));
		
		System.out.println(path2.getFileName()); // prints Path test2.txt
		
		System.out.println(path2.getNameCount()); //prints 10 ( indexing starts from 0 )
		
		System.out.println(path1.subpath(0, 1)); //prints path Users ( indexing starts from 0)
		
		System.out.println(Paths.get("dir1\\testing\\.\\..\\dir2\\.\\..\\testing1").normalize());
		
		System.out.println(path2.getRoot());
		
		System.out.println(dir2.getFileSystem());
		
		System.out.println(dir2.isAbsolute());
		
		System.out.println(path1.relativize(path2));	//prints ..\test1.txt
		
		// System.out.println(rel.relativize(path1)); This will cause  java.lang.IllegalArgumentException has you can't fix relative and absolute paths in relativize() method
		
		System.out.println(dir2.resolve(path1)); // if the parameter to resolve() that is path1 is absolute then only that is printed dir2 here is ignored
		
		System.out.println(dir2.resolve(rel));
		
		System.out.println(rel.toAbsolutePath());
		
		// System.out.println(rel.toRealPath());   This will throws a  java.nio.file.NoSuchFileException since the file does not exists. It is the only method that actually checks 
											   //  if the file at the given path exists or not.
											   //  First it obtains the absolute path then it calls normalize() and then it checks for the actual existence of the file or directory
		
		java.io.File file=rel.toFile();
		
		Path tmp=file.toPath();
		
		
		/*Path pp=Paths.get("/yo");
		Path ppp=Paths.get("C:\\yo");
		System.out.println(Files.isSameFile(pp,ppp));
				*/
		
		
	}
	
	
	
}
