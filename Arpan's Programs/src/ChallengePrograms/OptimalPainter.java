/*
 
Oz's paintings https://www.hackerearth.com/problem/algorithm/ozs-paintings-16/
--------------


Today Oz wants to make some money through his paintings. For painting, Oz has X white color pens, Y red color pens and Z green color pens. Their are 4 types of paintings he wants to make i.e. 

First kind of painting needs 3 white color pens.
Second kind of painting needs 3 red color pens.
Third kind of painting needs 3 green color pens.
Fourth kind of painting needs 1 white, 1 red and 1 green color pen.
Oz wants to earn more money so he wants to make maximum number of paintings. Help Oz to find the maximum number of paintings he can make.

Input :
The first line contains the number of test cases T. Each test case consists of 3 integers X, Y and Z — the number of white, red and green color pens.

Output :
For each test case print the maximum number of paintings Oz can make.

Constraint :

1<= T <= 10
0 <= X, Y, Z <= 10^9


-------------------------

Sample Input : 4 4 4
Sample Output : 4

Explanation

Oz can make 1 first kind, 1 second kind, 1 third kind and 1 fourth kind painting

Time Limit:	1.0 sec(s) for each input file.

Memory Limit:	256 MB

Source Limit:	1024 KB
*/

 



package ChallengePrograms;
import java.util.Scanner;



public class OptimalPainter
{

private long white;
private long red;
private long green;
private long PaintingCount;

void get(Scanner temp)
{
	
	
    white=temp.nextLong();
    red=temp.nextLong();
    green=temp.nextLong();
	
   
    
}

void put()
{
    System.out.println(PaintingCount);
}

void ComputeOptimalPainting()
{
	
	
	long p1,p2,p3,p4;
	
	p1=p2=p3=p4=0;
	
	if(white>0 && red>0 && green>0) { white--; red--; green--; p4=painting4(PaintingCount,white,red,green); }
	
    else if(white>2) { white=white-3; p1=painting1(PaintingCount,white,red,green); }
    
    else if(red>2) { red=red-3; p2=painting2(PaintingCount,white,red,green); }
    
    else if(green>2) { green=green-3;  p3=painting3(PaintingCount,white,red,green); }
    
    
    else {}
    
    PaintingCount=max(p1,p2,p3,p4);
    
    
}




private long painting1(long PaintingCount,long white,long red,long green)
{
    long w=white;
    long p1,p2,p3,p4;
    p1=p2=p3=p4=0;
    
    
    
    
    PaintingCount++;
    
   
    
    if(w>0 && red>0 && green>0) {  w--; red--; green--;    p4=painting4(PaintingCount,w,red,green);}
    if(w>2) {    w=w-3; p1=painting1(PaintingCount,w,red,green);  }
    if(red>2) {   red=red-3;   p2=painting2(PaintingCount,w,red,green);}
    if(green>2) {   green=green-3;   p3=painting3(PaintingCount,w,red,green);}
    
    
    
    return max(p1,p2,p3,p4,PaintingCount);
    
    
}


private long painting2(long PaintingCount,long white,long red,long green)
{
    long r=red;
    long p1,p2,p3,p4;
    p1=p2=p3=p4=0;
    
    
    
    PaintingCount++;
    
    if(white>0 && r>0 && green>0) {  white--; r--; green--; p4=painting4(PaintingCount,white,r,green); }
    
    if(white>2) { white=white-3; p1=painting1(PaintingCount,white,r,green); }
    
    if(r>2) { r=r-3; p2=painting2(PaintingCount,white,r,green);   }
    
    if(green>2) { green=green-3; p3=painting3(PaintingCount,white,r,green);  }
    
    
    
    return max(p1,p2,p3,p4,PaintingCount);
}


private long painting3(long PaintingCount,long white,long red,long green)
{
    long g=green;
    long p1,p2,p3,p4;
    p1=p2=p3=p4=0;
    
   
    
    
    PaintingCount++;
   
    if(white>0 && red>0 && g>0) {  white--; red--; g--; p4=painting4(PaintingCount,white,red,g);}
    if(white>2) {  white=white-3; p1=painting1(PaintingCount,white,red,g);}
    if(red>2) {  red=red-3; p2=painting2(PaintingCount,white,red,g);}
    if(g>2) {  g=g-3; p3=painting3(PaintingCount,white,red,g);}
    
    
    return max(p1,p2,p3,p4,PaintingCount);
}


private long painting4(long PaintingCount,long white,long red,long green)
{
    long w=white;
    long r=red;
    long g=green;
    long p1,p2,p3,p4;
    p1=p2=p3=p4=0;
    
   
  
    System.out.println("here");
    
    PaintingCount++;
    
    if(w>0 && r>0 && g>0) {  w--; r--; g--; p4=painting4(PaintingCount,w,r,g);}
    if(w>2) {  w=w-3; p1=painting1(PaintingCount,w,r,g);}
    if(r>2) {  r=r-3; p2=painting2(PaintingCount,w,r,g);}
    if(g>2) {  g=g-3; p3=painting3(PaintingCount,w,r,g);}
    
    
   
    
    return max(p1,p2,p3,p4,PaintingCount);
}

long max(long ...a)
{
	long max=a[0];
	for(long i:a)
	{
		if(i>max) max=i;
	}
	
	return max;
}

public static void main(String args[])
{
    
    
    Scanner temp=new Scanner(System.in);
    long TestCases=temp.nextLong();
    
    for(long i=0;i<TestCases;i++)
    {
    	OptimalPainter obj=new OptimalPainter();
    	obj.get(temp);
    	obj.ComputeOptimalPainting();
    	obj.put();
    }
    temp.close();
}
}


