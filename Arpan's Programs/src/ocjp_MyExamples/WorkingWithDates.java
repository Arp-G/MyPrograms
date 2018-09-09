package ocjp_MyExamples;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class WorkingWithDates {

	public static void main(String args[])
	{
		LocalDate date=LocalDate.now();
		
		LocalDate CustomDate=LocalDate.of(2018,4,2);
		
		LocalTime Time=LocalTime.now();
		
		LocalTime CustomTime=LocalTime.of(11,50,33);
		
		LocalDateTime DateTime=date.atTime(Time); // combining date with time
		
		LocalDateTime CustomDateTime=CustomTime.atDate(CustomDate); // combining time with date
		
		System.out.println(date);
		System.out.println(Time);
		System.out.println(DateTime);
		System.out.println();
		
		
		Period PDay=Period.ofDays(10);
		Period PMonth=Period.ofMonths(3);
		Period PYear=Period.ofYears(2);
		
		Period PP=Period.of(10, 3, 2);
		
		DateTimeFormatter fmat=DateTimeFormatter.ofPattern("'Format :' d M Y");
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		
		System.out.println("Before Formatting "+date);
		System.out.println(date.format(fmat));
		
		String str=date.format(fmat);
		
		System.out.println(date.isBefore(CustomDate));
		
		
		
		//System.out.println(LocalDate.parse("2017-01-04",fmat));
		
		
		
	}
}
