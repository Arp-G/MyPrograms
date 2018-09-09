import java.util.*;

public class AdditiveResourceBundles 
{

	
	
	public static void main(String args[])
	{
		ResourceBundle rb=ResourceBundle.getBundle("Test",new Locale("en","US"));
		
		System.out.println(rb.getString("key1"));
		System.out.println(rb.getString("key2"));
		System.out.println(rb.getString("key3"));
		System.out.println(rb.getString("key4"));
	}
}
