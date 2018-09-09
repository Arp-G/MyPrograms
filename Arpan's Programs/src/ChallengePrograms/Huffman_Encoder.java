package ChallengePrograms;

import java.util.*;

public class Huffman_Encoder 
{
	static public String Code="";
	
	public static void main(String args[])
	{
		
		System.out.println("Enter a String to be encoded : ");
		
		Scanner sc=new Scanner(System.in);
		
		String str=sc.nextLine();
		
		sc.close();
	
		ArrayList<Element> Elements=FindChars(str);
	
		Element root=MakeHeap(Elements);
	
		ArrayList<Element> ElementCpy=FindChars(str);// MakeHeap changes Elements so we create it again
		
		ArrayList<ElementCode> coded=CodeMaker(ElementCpy,root);
		
		String RleEncoded=RLE_Encoder(ElementCpy);
		
		System.out.println("Encoding Results: ");
		
		System.out.println("-------------------");
		
		System.out.println("Given Data : "+str);
		
		System.out.println("RLE Encoded Data : "+RleEncoded);
		
		double comp_ratio=((double)RleEncoded.length())/str.length();
		
		System.out.println("Compression Ratio(Assuming each character is of 8 bytes) = ("+str.length()+"*8)/"+RleEncoded.length()+" = "+comp_ratio);
		
		System.out.println();
		
		System.out.println("Huffman Encoded Data :");
		System.out.println("----------------------");
		
		System.out.println();
		
		int huffmanCodeSize=0;
		
		for(int i=0;i<coded.size();i++)
		{
			System.out.println("Element : "+(coded.get(i)).element+"   Code  : "+(coded.get(i)).Code);
			
			huffmanCodeSize=huffmanCodeSize+coded.get(i).Code.length()*(coded.get(i).Frequency);  //Sum of( No of bits used to represent the character * No of times the character has appeared in the String
		}
		
		comp_ratio=(str.length()*8)/((double)huffmanCodeSize);
		
		System.out.println();
		
		System.out.println("Rough Sketch of the Tree for huffman Encoding...");
		
		System.out.println();
		
		Tree_Builder<Element> obj=new Tree_Builder<Element>();
		
		obj.startBuild(root);
		
		
		System.out.println("Compression Ratio(Assuming each character is of 8 bytes) = ("+str.length()+"*8)/"+huffmanCodeSize+" = "+comp_ratio);
		
		System.out.println();
		
		System.out.println("------------------------------------------------------------------Designed with love and passion by Arpan");
		
	}
	
	static ArrayList<Element> FindChars(String s)
	{
		ArrayList<Element> arr=new ArrayList<>();
		
		arr.add( new Element( "" + s.charAt(0) ) );
		
		char ch;
		
		for(int i=1;i<s.length();i++)
		{
			ch=s.charAt(i);
			
			boolean flag=true;
			
			for(int j=0;j<arr.size();j++)
			{
				if( (""+ch) . equals ( (arr.get(j) ).Name) )
				{
						flag=false;
						break;
				}
			}
			if(flag)
			{
				arr.add( new Element( "" + ch));
			}
		}
		
		int count;
		String tmp;
		
		for(int j=0;j<arr.size();j++)
		{
			count=0;
			
			tmp=arr.get(j).Name;
			
			for(int i=0;i<s.length();i++)
			{
				if(tmp.equals( "" + s.charAt(i)) ) count++;
			}
			(arr.get(j)).SetFrequency(count);
		}
		
		return arr;
		
	}
	
	static Element MakeHeap(ArrayList<Element> arr)
	{
		Comparator<Element> ByFrequency = (obj1,obj2) ->(int) ( obj1.Frequency - obj2.Frequency ); // Comaparator to Sort all the elements by there frequency
		
		ArrayList<Element> MinHeap=new ArrayList<>();
		
		Element Parent,Left,Right;
		
		Parent=Left=Right=null;
		
		while(arr.size()>=2)
		{
		    Collections.sort(arr,ByFrequency);
		
			Left=new Element(arr.get(0));
			
			Right=new Element(arr.get(1));
		
			Element NewElement=new Element( Left.Name+Right.Name , Left.Frequency+Right.Frequency,Left,Right);
		
			Parent=new Element(NewElement);
		
			Parent.LeftLink=Left;
		
			Parent.RightLink=Right;
			
			MinHeap.add(Parent);
			MinHeap.add(Left);
			MinHeap.add(Right);
		
			//Remove first 2 elements from arr
			arr.remove(0);
			arr.remove(0);
	        arr.add(0,NewElement);
		
		}
		
		return Parent;//return a reference of the root of the MinHeap
	}

	static ArrayList<ElementCode> CodeMaker(ArrayList<Element> element,Element root)
	{
		ArrayList<ElementCode> coded=new ArrayList<>();
		
		
		for(int i=0;i<element.size();i++)
		{
			
			FindCode(element.get(i).Name,root,"");
			coded.add(new ElementCode(element.get(i).Name,element.get(i).Frequency,Code));
		}
		return coded;
	}
	
	static void FindCode(String target,Element root,String code)
	{
		if( (root.Name).equals(target) ) {Code=code;}
		
		if(root.LeftLink != null) FindCode(target , root.LeftLink ,code+"0");
		
		if(root.RightLink != null) FindCode(target , root.RightLink ,code+"1");
	}

	static String RLE_Encoder(ArrayList<Element> element)
	{
		String RleEncoded="";
		
		for(int i=0;i<element.size();i++)
		{
			RleEncoded=RleEncoded+element.get(i).Frequency+element.get(i).Name;
		}
		
		return RleEncoded;
	}
}


class Element implements ChallengePrograms.Drawable<Element>
{
	String Name;
	int Frequency;
	Element LeftLink;
	Element RightLink;
	int count=0;
	
	Element(String Name,int Frequency)
	{
		this.Name=Name;
		this.Frequency=Frequency;
		LeftLink=RightLink=null;
	}
	
	Element(String Name)
	{
		this.Name=Name;
		this.Frequency=0;
		LeftLink=RightLink=null;
	}
	
	Element(String Name,int Frequency,Element LeftLink,Element RightLink) 
	{
		this.Name=Name;
		this.Frequency=Frequency;
		this.LeftLink=LeftLink;
		this.RightLink=RightLink;
	}
	
	Element(Element L,Element R)
	{
		LeftLink=L;
		RightLink=R;
	}
	
	Element(Element e) // Copy Constructor
	{
		this.Name=e.Name;
		this.Frequency=e.Frequency;
		this.LeftLink=e.LeftLink;
		this.RightLink=e.RightLink;
	}
		
	void SetFrequency(int Frequency)
	{
		this.Frequency=Frequency;
	}
	
	public Element GetLeftChild() 
	{
		return LeftLink;
	}
	
	public Element GetRightChild() 
	{
		return RightLink;
	}
	
	public Drawable<Element> SetLeftChild()
	{
		this.LeftLink=new Element("B-A-D",0);
		
		return this.LeftLink;
	}
	
	public Drawable<Element> SetRightChild()
	{
		this.RightLink=new Element("B-A-D",0);
		
		return this.RightLink;
	}
	
	public boolean IsRedundant()
	{
		if(this.Name.equals("B-A-D") && this.Frequency==0) return true;
		else return false;
	}

	
	public void setCount(int count)
	{
		this.count=count;
	}
	
	public int getCount()
	{
		return this.count;
	}

	public String Print()
	{
		return Name+","+Frequency;
	}
	
}


class ElementCode
{
	String element;
	int Frequency;
	String Code;
	
	ElementCode(String element,int Frequency,String Code)
	{
		this.element=element;
		this.Frequency=Frequency;
		this.Code=Code;
	}
}










