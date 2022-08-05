package artplancom1.Facade;

import java.util.Calendar;
import java.util.Date;

import artplancom1.Component.InputStringComponent;

public class InputStringFacade {

	private int[] timeLimitsArray = new int[] {1000, 10000, 100000};
	
	public String reversePrintAndCountTime(String inputString) {
		
		InputStringComponent inputStringComponent = new InputStringComponent();
		Calendar calendarStart = Calendar.getInstance();

	    Calendar calendarEnd = Calendar.getInstance();
	    
		String stringReversed = new String();
		long difference;
		
		for(int timeLimit : timeLimitsArray) {
			calendarStart.setTimeInMillis((new Date()).getTime());
			stringReversed = inputStringComponent.reverseString(inputString);
			for(int i = 0; i < timeLimit; i++) {
				stringReversed = inputStringComponent.reverseString(stringReversed);
			}
			calendarEnd.setTimeInMillis((new Date()).getTime());
			
			difference = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
			System.out.println("При повторении на " + timeLimit + " раз ушло: " + String.format("%.10f", (float)(difference / 1000)) + " секунд.");
		}
		
		return stringReversed;
	}
	
}
