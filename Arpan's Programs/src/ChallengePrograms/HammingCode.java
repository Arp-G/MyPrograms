package ChallengePrograms;

import java.util.Scanner;

public class HammingCode 
{
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String args[])
	{
		
		System.out.println("--------------------------HAMMING CODE ENCODING AND ERROR CORRECTION--------------------------");
		
		System.out.println();
		
		Hamming_Encoder();
		
		System.out.println();
		
		System.out.println();
		
		Hamming_Checker();
		
		System.out.println("--------------------------------------------------------Created with Love and Passion by Arpan");
	}
	
	
	static void Hamming_Encoder()
	{
		System.out.println("Enter the Data word to be coded : ");
		
		String Data=sc.next();
		
		System.out.println("Given Data is : "+Data);
		
		int par=ParityBitLength(Data); // Returns the number of Parity bits required
		
		System.out.println("Number of Parity bits required is "+par);
		
		Data=InsertParity(Data,par);
		
		System.out.println("Parity Positions are "+Data);
		
		System.out.println("Coded Data is        "+FindParity(Data));
	}
	
	static int ParityBitLength(String Data)
	{
		int i=0;
		
		int len=Data.length()+1; // 2^r >= r+(length of data word given)+1 => r<= 2^r - (length of data word given)-1
		
		while(true)
		{
			if(Math.pow(2,i)-len >= i) break;
			i++;
		}
		
		return i;
	}
	
	static String InsertParity(String Data,int par)
	{
		String str1,str2;
		
		int len=Data.length();
		
		for(int i=0;i<(len+par);i++)
		{
			if(ChkPow(i+1))//check if position is a power of 2
			{
				str1=Data.substring(0,i);
				
				str2=Data.substring(i,Data.length());
				
				Data=str1+"P"+str2;
			}
		}
		return Data;
	}
	
	static boolean ChkPow(int i)
	{
		int j=0;
		int k=0;
		while(j<i)
		{
			
			j=(int)Math.pow(2, k);
			if(j==i) return true;
			k++;
		}
		
		return false;
	}
	
	static String FindParity(String Data)
	{
		int ParityCount=0,EvenParity;
		
		for(int i=0;i<Data.length();i++)
		{
			if(Data.charAt(i)=='P') // For every Parity Position
			{
				ParityCount++;
				
				EvenParity=0;
				
				for(int k=1;k<=Data.length();k++) // Check Parity Positions for Parity "ParityCount"
				{
					if(IsParityBit(Data,ParityCount,k)) 
					{
						
						if(Data.charAt(k-1)=='1') EvenParity++;//if (k)th position is a parity bit for (ParityCount)th parity position and value at that position is 1 then increment even parity
					}
				}
					
				if(EvenParity%2==0 ) Data=Data.substring(0,i)+"0"+Data.substring(i+1,Data.length());
				
				else Data=Data.substring(0,i)+"1"+Data.substring(i+1,Data.length());
			}
		}
		return Data;
	}
	
	static boolean IsParityBit(String Data,int ParityCount,int k) //Checks if "k" is a Parity bit for Parity "ParityCount"
	{
		StringBuilder rev = new StringBuilder(Integer.toBinaryString(k));
		
		rev.reverse();
		
		for(int i=1;i<=rev.length();i++)
		{
				if(i==ParityCount && rev.charAt(i-1)=='1') return true;
				
				if(i==ParityCount && rev.charAt(i)!='1')  break;
				
		}
		
		return false;	
	}
		
	static void Hamming_Checker()
	{
		System.out.println("Enter a coded data to check (upto one bit error allowed)");
		
		String Code=sc.next();
		
		sc.close();
		
		int syn=DataBitLength(Code);
		
		System.out.println("Number of Syndrome bits in the Code is "+syn);
		
		System.out.println("Original Data :          "+Code);
		
		String SyndromePos=Syndrome_Positions(Code);
		
		System.out.println("Syndrome bit Positions : "+SyndromePos);
		
		String tmp=MakeSyndrome(Code,SyndromePos);
		
		int ErrorPos=ErrorAt(tmp);
		
		if(ErrorPos==0) System.out.println("There is no error in the given code");
		
		else 
			{
				System.out.println("There is an error at bit positon "+ErrorPos);
				
				System.out.println();
				
				System.out.println("Original Code :  "+Code);
				
				System.out.print("                 ");
				
				for(int i=0;i<ErrorPos-1;i++) System.out.print(" ");	
				
				System.out.println("^");
				
				if(Code.charAt(ErrorPos-1)=='1') Code=Code.substring(0,ErrorPos-1)+"0"+Code.substring(ErrorPos,Code.length());
				
				else Code=Code.substring(0,ErrorPos-1)+"1"+Code.substring(ErrorPos,Code.length()); 
				
				System.out.print("Corrected Code : ");
				
				System.out.println(Code);
		}
	}
	
	static int DataBitLength(String Code)
	{
		int i=0;
		
		while(true)
		{
			if(Math.pow(2,i)>= Code.length()) break; // 2^r >= r+(length of data word given)+1 => (length of data word given) >= (2^r)-r-1
			i++;
		}
		
		return i;
	}

	static String Syndrome_Positions(String Code)
	{
		String str="";
		for(int i=0;i<Code.length();i++)
		{
			if(ChkPow(i+1)) str+="S";
			
			else str+=" ";
		}
		return str;
	}

	static String MakeSyndrome(String Code,String SyndromePos)
	{
		String Syndrome="";
		
		int SyndromeCount=0;
		
		for(int i=0;i<Code.length();i++)
		{
			if(SyndromePos.charAt(i)=='S') 
			{
				SyndromeCount++;
				
				Syndrome=CalcSyndrome(Code,SyndromeCount)+Syndrome;
			}
		}
		
		return Syndrome;
		}
	
	static int CalcSyndrome(String Code,int S)
	{
		int EvenParity=0;
		
		for(int j=0;j<Code.length();j++)
		{
			if(IsParityBit(Code,S,j+1) && Code.charAt(j)=='1')
			{
				EvenParity++;
			}
			
		}
		
		if(EvenParity%2==0) return 0;
		
		else return 1;
	}
	
	static int ErrorAt(String Syndrome) // Binary to Decimal Converter
	{
		int sum=0;
		
		int ForwardCount=-1;
		
		for(int i=Syndrome.length()-1;i>=0;i--)
		{
			ForwardCount++;
			
			if(Syndrome.charAt(i)=='1')	sum+=Math.pow(2,ForwardCount);
		}
		
		return sum;
	}
}