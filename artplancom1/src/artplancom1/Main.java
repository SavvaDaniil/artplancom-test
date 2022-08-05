package artplancom1;

import java.util.Scanner;

import artplancom1.Facade.InputStringFacade;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        
        InputStringFacade inputStringFacade = new InputStringFacade();
        inputString = inputStringFacade.reversePrintAndCountTime(inputString);
        System.out.println("Развернутая строка: " + inputString);
        
        scanner.close();
	}
}
