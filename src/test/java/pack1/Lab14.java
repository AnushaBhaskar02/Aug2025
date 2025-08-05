package pack1;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Lab14 {
	 public static void main(String[] args) {
	        ZonedDateTime timeInIndia = ZonedDateTime.now(ZoneId.of( "Asia/Kolkata" ));
	        System.out.println("Current time in India: " + timeInIndia);
	    }
}
