package ChangeMaker;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		float priceOfItem = enterPrice(kb);

		String yesOrNo = isThisCorrect(priceOfItem, kb);

		priceOfItem = verify(yesOrNo, priceOfItem, kb);

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

	}// end is this correct method

	// ask cashier if they entered the right amount
	public static float verify(String yesOrNo, float price, Scanner s) {
		boolean yes = true;
		
		switch (yesOrNo) {
		case "Y":
		case "y":
		case "yes":
		case "Yes":
			System.out.println("The correct price is " + price);
			break;
		case "N":
		case "n":
		case "no":
		case "No":
			System.out.print("Please enter correct price: ");
			price = s.nextFloat();
			String newYesOrNo = isThisCorrect(price, s);
			verify(newYesOrNo, price, s);		
		}// end switch
		return price;
	}// end verify method

}// end class
