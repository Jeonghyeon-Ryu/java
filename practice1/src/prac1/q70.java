package prac1;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class q70 {
	public static void main(String[] args) throws InterruptedException {
		Instant login = Instant.now();
		Thread.sleep(1000);
		
		Instant logout = Instant.now();
		
		login = login.truncatedTo(ChronoUnit.MINUTES);
		logout = logout.truncatedTo(ChronoUnit.MINUTES);
		
		if(logout.isAfter(login)) {
			System.out.println("log out at " + logout);
		} else {
			System.out.println("Can't logout");
		}
	}
}
