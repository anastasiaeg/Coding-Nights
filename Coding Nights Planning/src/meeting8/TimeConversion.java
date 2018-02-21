package meeting8;

import java.util.Random;

public class TimeConversion {
	
	public static void main(String[] args) {
		String s = "12:12:45AM";
		String result = timeConversion(s);
		System.out.println(result);
		}
	
	public static String timeConversion(String s) {
    // get last two characters
    String AMorPM = s.substring(s.length() - 2);
    String hour = "";
      
    if (AMorPM.equals("AM")){
        hour = s.substring(0,2);
        // midnight special case
       if ((Integer.parseInt(s.substring(0,2))) == 12){
           hour = "00";
           }
    }
      
    else {
       int NumHour = (Integer.parseInt(s.substring(0,2))) + 12;
       hour = Integer.toString(NumHour);
       // noon special case
       if ((Integer.parseInt(s.substring(0,2))) == 12){
           hour = "12";
           }
    }
      
    return (hour + s.substring(2, s.length() - 2));
	}
	
}