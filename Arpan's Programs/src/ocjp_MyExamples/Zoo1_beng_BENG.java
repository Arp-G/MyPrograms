package ocjp_MyExamples;

import java.util.ListResourceBundle;



public class Zoo1_beng_BENG extends ListResourceBundle
{
	protected Object[][] getContents() //Overriding the abstract method of ListResourceBundle class which is inherited
	{
		return new Object[][] { {"Whats up ?" , new Example("Ki cholche")} , {"Everthings fine", new Example("Sob bhalo")} }; 
	}
}

class Example
{
	String str;
	
	Example(String str)
	{
		this.str=str;
	}
	
	public String toString()
	{
		return this.str;
	}
}
