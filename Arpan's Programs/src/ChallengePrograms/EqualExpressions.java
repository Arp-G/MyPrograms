package ChallengePrograms;

import java.util.*;
import java.lang.*;

public class EqualExpressions
 {
	public static void main (String[] args)
	 {
    	 Scanner sc=new Scanner(System.in);
    	 
    	 int t=sc.nextInt();
    	 sc.nextLine();
    	 
    	 while(t!=0)
    	 {
    	     String str1=sc.nextLine();
    	     String str2=sc.nextLine();
    	     
    	     try{
    	     
    	     str1=sorter(resolveBrackets(addPlus(str1)));
    	     
    	     str2=sorter(resolveBrackets(addPlus(str2)));
    	     }
    	     catch(Exception e)
    	     {
    	         System.out.println("Inputs : "+str1+"     "+str2);
    	     }
    	     
    	     if(str1.equals(str2))
    	        System.out.println("YES");
    	     else
    	        System.out.println("NO");
    	     t=t-1;
    	 }
    	 
    	 sc.close();
	 }
	 
	static String addPlus(String str)
    {
        String str1="";
        
        int i=0;
        
        while(i<str.length())
        {
            char ch=str.charAt(i);
            
            if(ch>='a' && ch<='z') //ch is a letter
            {
                if(i==0)
                    str1="+";
                    
                else if(str.charAt(i-1)!='-' && str.charAt(i-1)!='+')
                    str1=str1+"+";
                
                    
            }
            
                    str1=str1+ch;
                
                
            i++;
        }
        
        return str1;
    }
    
    static String resolveBrackets(String str)
    {
        String str1="";
        
        int p_count=0;
        
        boolean flag=false,bracketflag=false;
     
            for(int i=0;i<str.length();i++)
            {
                 char ch=str.charAt(i);

                if(!flag )
                {
                    if(ch=='(' )
                    {
                        bracketflag=true;
                        str1=str1.substring(0,str1.length()-1);
                        
                        if(i!=0 && str.charAt(i-1)=='-')
                            flag=true;
                        
                        p_count++;
                        continue;
                    }
                }
            
                if(flag)
                {
                    if(ch=='+' && p_count==1)
                        ch='-';

                    else if(ch=='-' && p_count==1)
                        ch='+';
                }
                
                    if(ch=='(')
                        p_count++;
                        
                    if(ch==')')
                    {
                        p_count--;
                        
                        if(bracketflag && p_count==0)
                        {
                            if( i!= str.length()-1)
                                str1=str1+str.substring(i+1,str.length());
                            break;
                        }
                    }
                    
                str1=str1+ch;
            }
            
        if(flag)
            return resolveBrackets(str1);
        else
            return str1;
    }
    
    static String sorter(String str)
    {
        class Element implements Comparable<Element>
        {
            char sign;
            char variable;
            
            Element(char sign,char variable)
            {
                this.sign=sign;
                this.variable=variable;
            }
            
            public int compareTo(Element e)
            {
                return this.variable-e.variable;
            }
            
            public String toString()
            {
                return ""+sign+variable;
            }
        }
        
        
        List<Element> arr=new ArrayList<>();
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            
            if(ch>='a' && ch<='z') 
            {
                arr.add(new Element(str.charAt(i-1),ch));
            }
        }
        
        Collections.sort(arr);
        
        str="";
        
        for(Element tmp:arr)
        {
            str=str+tmp.toString();
        }
        
        return str;

    }
 }