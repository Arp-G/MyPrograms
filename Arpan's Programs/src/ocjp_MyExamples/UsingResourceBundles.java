package ocjp_MyExamples;

import java.util.*;
import java.io.*;


/* There are 3 ways in which resources can be used
 * 
 * 1) by using .properties files and the getString(String key) method as shown in the printProperties() method given here
 * 
 * 2) by using a class which inherits ListResourceBundle (that is in this example ocjp_MyExamples.Zoo1_beng_BENG.java and thus this class is a resource bundle class).
 * 	  We use the getObject(String key) method to get the values 
 * 	  This is shown in the create_Map_from_resource_bundle() method
 * 
 * 3) by using the class Properties. We insert keys and values in the Properties object and then use the getProperty(String key,String defaultValue) method to access all values This is shown in the Accessing_Resource_from_Properties() method
 * 
 */

public class UsingResourceBundles 
{
	public static void main(String args[])
	{
		Locale us=new Locale("en","US");
		Locale france=new Locale("fr","FR");
		
		
		
		printProperties(us);
		
		System.out.println();
		
		printProperties(france);
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Values in Zoo_en.properties");
		
		create_Map_from_resource_bundle(us);
		
		System.out.println();
		
		System.out.println("Values in Zoo_fr.properties");
		
		create_Map_from_resource_bundle(france);
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		Accessing_Resource_from_Properties(us);
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		Locale bengali=new Locale("beng","BENG"); // create a locale for Bengali
		
		resourse_bundle_from_ResourceBundleClass(bengali); // using a class zoo1 as resource bundle to display messages in Bengali corresponding to English messages
		
		
	}
	
	public static void printProperties(Locale locale) // depending on the Locale value passed either  Zoo_en or Zoo_fr is accessed
	{
		ResourceBundle rb=ResourceBundle.getBundle("ocjp_MyExamples.Resource_Bundles.Zoo",locale); // Using Zoo_en.properties and Zoo_fr.properties as resource bundle files present in ocjp_MyExamples/Resource_Bundles/
		System.out.println(rb.getString("hello"));  // get the value corresponding to the key value "hello"
		System.out.println(rb.getString("open"));   // get the value corresponding to the key value "open"
		
		// If the String or key passed to getString() is not found we get a MissingResourceException
	
	}
	
	public static void create_Map_from_resource_bundle(Locale locale)
	{
		ResourceBundle rb=ResourceBundle.getBundle("ocjp_MyExamples.Resource_Bundles.Zoo",locale);
		
		Set<String> keys=rb.keySet(); // This creates a Set<String> from all key values present in the resource bundle rb
		
		keys.stream().map(k->k+" "+rb.getString(k)).forEach(System.out::println); // Creating a stream and mapping all keys given by k to there corresponding values given by getString(k) and then displaying them
	}
	
	
	/* Here instead of creating .properties file for a resource bundle we have created a class ocjp_MyExamples.Zoo1 which inherits ListResourceBundle and thus this class is a resource bundle class.
	 * Using resource bundle class instead of .properties files have certain advantages. For classes the value corresponding to a key may not always be a string(as in case of .properties files) it can 
	 * be an object also like in the Zoo1 class used here the values corresponding to keys are actually objects of another class called Example (however keys are always strings).
	 * Moreover classes used as resource bundles can create values at runtime */
	
	public static void resourse_bundle_from_ResourceBundleClass(Locale local)
	{
		ResourceBundle rb=ResourceBundle.getBundle("ocjp_MyExamples.Zoo1",local);
		
		ocjp_MyExamples.Example a=(ocjp_MyExamples.Example)rb.getObject("Whats up ?"); // Proper casting is needed since Object is returned
		
		System.out.println(rb.getObject("Whats up ?"));
		
		System.out.println(rb.getObject("Everthings fine"));
		
		
	}
	
	
	public static void Accessing_Resource_from_Properties(Locale local)
	{
		Properties props=new Properties();
		
		// here we create a properties class object and insert values in it from a .property file
		
		ResourceBundle rb=ResourceBundle.getBundle("ocjp_MyExamples.Resource_Bundles.Zoo",local);
		
		rb.keySet().stream().forEach(k->props.put(k, rb.getString(k)));
		
		// Accessing Values from property
		
		System.out.println(props.getProperty("open"));
		
		System.out.println(props.getProperty("yoyo")); // there is no key called yoyo so null is printed
		
		System.out.println(props.getProperty("yoyo","there is no key called yoyo so this deafult 2nd parameter passed to getProperty() is called"));	
		
		String tmp=(String)props.get("open"); // The get() method on properties also works but returns Object so needs casting. Without the cast (String) this wont work
		
		
	}
}






