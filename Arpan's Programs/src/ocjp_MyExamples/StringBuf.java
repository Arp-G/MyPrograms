package ocjp_MyExamples;

public class StringBuf 
{
	public static void main(String args[])
	{
		String s;
		int a=42;
		StringBuffer sb=new StringBuffer(40);// Make a String Buffer object of size 40
		
		s=sb.append(" a = ").append(a).append("!").toString();// toString() converts String
		System.out.println(s);
		
	}
}

	