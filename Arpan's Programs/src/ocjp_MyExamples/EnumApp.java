package ocjp_MyExamples;
enum Week
{
	WeekDay,WeekEnd;
}

enum Day
{
	Sunday(Week.WeekEnd) , Monday(Week.WeekDay) , Tuesday(Week.WeekDay) , Wednesday(Week.WeekDay) , Thrusday(Week.WeekDay) , Friday(Week.WeekDay) , Saturday(Week.WeekEnd);
	
	private Week What;
	
	Day(Week What)
	{
		this.What=What;
	}
	
	
	Week getWeek() 
	{
		return What;
	}
}


public class EnumApp
{
	public static void main(String args[])
	{
		if(Day.Sunday.getWeek()==Week.WeekEnd)
		{
			System.out.println("Sunday is Week End");
		}
		
		if(Day.Monday.getWeek().equals(Week.WeekDay))
		{
			System.out.println("Monday is Week Day");
		}
	
	
		if(Day.Monday.compareTo(Day.Sunday)<0) //This works since enums implement Comparable interface
		{
			System.out.println("Monday comes before Sunday");
		}
		else if(Day.Monday.compareTo(Day.Sunday)>0)
		{
			System.out.println("Monday comes after Sunday");
		}
		else // Days.Monday.compareTo(Days.Sunday) == 0
		{
			System.out.println("Monday and  Sunday are the same");
		}
	
	Day alldays[]=Day.values();
	
	for(Day temp : alldays)
	{
	
			System.out.println(temp.name() + " => " + (temp.ordinal() + 1) ); // temp.ordinal() gives the position of the constant in the enumeration (starting from 0)
	
	}
	
	
	}
}