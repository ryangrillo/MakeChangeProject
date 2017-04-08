package ChangeMaker;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		float priceOfItem;
		float tendered;

		priceOfItem = enterPrice(kb);// asks for price and stores it in variable

		String yesOrNo = isThisCorrect(priceOfItem, kb);// asks customer if
														// price is correct and
														// keeps looping until
														// customer says yes
		priceOfItem = verify(yesOrNo, priceOfItem, kb);// stores correct price
														// in variable
		tendered = howMuchWasTendered(kb);
		System.out.println(tendered + "was given form customer");

		kb.close();
	}// end main

	public static float enterPrice(Scanner s) {
		System.out.println("Please enter the Price of the item: ");
		float itemPrice = s.nextFloat();
		return itemPrice;
	}// end enterPrice method

	public static String isThisCorrect(float price, Scanner s) {
		System.out.println("You entered: " + price);
		System.out.println("Is $" + price + " correct (Y/N)");
		String verifyCorrectPrice = s.next();
		return verifyCorrectPrice;

	}// end "is this correct" method
	// ask cashier if they entered the right amount
	public static float verify(String yesOrNo, float price, Scanner s) {
		switch (yesOrNo) {
		case "Y":
		case "y":
		case "yes":
		case "Yes":
			// System.out.println("The correct price is " + price); <----might
			// not use
			break;
		case "N":
		case "n":
		case "no":
		case "No":
			System.out.print("Please enter correct price: ");
			price = s.nextFloat();
			String newYesOrNo = isThisCorrect(price, s);
			verify(newYesOrNo, price, s);
			break;
		default:
			System.out.println("you need to enter a valid dollar amount");
			enterPrice(s);// loops back to validate price method

		}// end switch
		return price; //returns correct price after it's validated
	}// end verify method
	//how much did the customer give?
	public static float howMuchWasTendered( Scanner t) {
		System.out.print("How much did the customer give you?");
		float givenFromCustomer;
		givenFromCustomer = t.nextFloat();
		return givenFromCustomer;
	}
	public static void checkIfTenderedCorrect(float checkGivenamount, Scanner yup) {
		System.out.print("You entered: $" + checkGivenamount + "\nis this correct? (Y/N)");
		String yayornay = yup.next();
		switch (yayornay) {
		case "Y":
		case "y":
		case "yes":
		case "Yes":
			break;
		case "N":
		case "n":
		case "no":
		case "No":
			System.out.print("Please enter correct amount given: ");
			
		
		}//end switch statement
	}//end "check if tendered correct" method
	
}// end class
