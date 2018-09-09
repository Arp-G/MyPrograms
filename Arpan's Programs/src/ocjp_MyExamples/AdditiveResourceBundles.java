package ocjp_MyExamples;

import java.util.*;

public class AdditiveResourceBundles 
{

	
	
	public static void main(String args[])
	{
		ResourceBundle rb=ResourceBundle.getBundle("ocjp_MyExamples.Resource_Bundles.AdditiveResources.Test",new Locale("en","US"));
		
		System.out.println(rb.getString("key1"));
	}
}
