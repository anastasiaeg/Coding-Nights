package meeting6;

public class CountingSundays2 {
	public static void main(String[] args) {
		
		int DaysInWeek = 7;
		int DaysInYear = 365;
		// Jan 1, 1901 is a Tuesday. Sunday is last day of week (7)
		int weekday = 2; 
		
		// start with date: 01/01/1901
		int day = 1;
		int month = 1;
		int year = 1901;
		
		// end on date: 12/31/2000
		int EndDay = 31;
		int EndMonth = 12;
		int EndYear = 2000;
		
		int NumSundays = 0;
		int DaysInMonth = 0;
		
		while (year <= EndYear) {
			DaysInMonth = getNumDays(month, year);
			
			day++;
			weekday++;
			
			// reset to Sunday at end of each week
			if (weekday > DaysInWeek) {
				weekday = 1;
			}
			// reach end of month
			if (day > DaysInMonth) {
				day = 1; 
				month++;
			}
			// reach end of year
			if (month > 12) {
				month = 1; 
				year++;
			}
			// is the Sunday on the first of the month?
			if (day == 1 && weekday == DaysInWeek)
			{
				NumSundays++;
			}	
		}
		System.out.println(NumSundays);
	}
	
	// Figure out the number of days in a particular month
	public static int getNumDays(int m, int y) {
		int NumDays = 0;
				switch (m) {
				
					// Sep, Apr, June, Nov has 30 days
					case 9: case 4: case 6: case 11:
						NumDays = 30;
						break;
						
					// February leap year special condition
					case 2:
						if ( ((y % 4 == 0) && !(y % 100 == 0)) || (y % 400 == 0)) {
							NumDays = 29;
						}
						else 
							NumDays = 28;
						break;
						
					// Else, month has 31 days
					default: 
						NumDays = 31;
						break;
				}
				return NumDays;
	}
	
	
}
