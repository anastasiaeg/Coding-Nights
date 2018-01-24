package countingsundays;
import java.util.Calendar;
import java.util.Date;

public class CountingSundays {
	public static void main(String[] args) {
		
		// don't worry about number of days, since starts on the first of a month, just increment by months and check if that day is a Sunday
		// this is dependent on use of the Java.util.Calendar package
		
		  Calendar start = Calendar.getInstance();
		  start.set(1901, Calendar.JANUARY, 1);
		  Calendar end = Calendar.getInstance();
		  end.set(2000, Calendar.DECEMBER, 31);
		  Calendar cal = Calendar.getInstance();
		  cal.set(1901, Calendar.JANUARY, 1);
		  int NumSundays = 0;
		  		  
		  while ( cal.before(end) )
		  {
			  if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			  {
				  NumSundays++;
			  }
			  
			  cal.add(Calendar.MONTH, 1);
		  }
		  
		  System.out.println(NumSundays);
	}
}