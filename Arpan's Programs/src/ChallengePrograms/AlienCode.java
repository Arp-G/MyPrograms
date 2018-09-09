package ChallengePrograms;



public class AlienCode 
{
	
	int length;
	String ch;


	void Lang_Reader(String Lang)
	{
		length=Lang.length(); // This is the base of the language ( For Ef decimal no system has base 10 )
		ch=Lang;
		
	}
	
		
	void rec(int i,String sub,int m)
	{
		String temp=sub+ch.charAt(i);
		
		System.out.println(temp);
		
		i++;
		
		if(i==length)
		{
			
			m++;
			System.out.println(m);
			sub="";
			i=0;
			
			
			
			if(m/((double)length)>1)
			{
				sub=sub+ch.charAt(m/length-1);
			}
				
				
			
				i = m % (length); 
			
			//sub="";
				
				if(i==0 ) {i=length;}
			
				sub= sub + ch.charAt(i-1);
			
				i=0;
			
				rec(i,sub,m);
			
			}
			
		
		else rec(i,sub,m);
	}
	
	public static void main(String args[])
	{
		
		AlienCode obj=new AlienCode();
		
		obj.Lang_Reader("abc");
		obj.rec(0, "", 0);
	}
	
}
	