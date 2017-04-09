package ChangeMaker;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		start();

	}// end main

	public static void start() {
		Scanner kb = new Scanner(System.in);

		float priceOfItem;
		float tendered;

		priceOfItem = enterPrice(kb);// asks for price and stores it in variable

		String priceYesOrNo = isThisCorrect(priceOfItem, kb);// asks customer if
		// price is correct and
		// keeps looping until
		// customer says yes
		float checkedPriceOfItem = verify(priceYesOrNo, priceOfItem, kb);// stores
																			// correct
																			// price
		// in variable
		tendered = howMuchWasTendered(kb);

		String tenderedYesorNo = isThisCorrect(tendered, kb);

		float checkedTender = checkIfTenderedCorrect(tenderedYesorNo, tendered, kb);

		float penniesOwed = startTransaction(checkedPriceOfItem, checkedTender);

		denomination(penniesOwed);

		// System.out.println("final is: " + penniesOwed); testing my result

		// float changeOwed = calc(checkedTender, checkedPriceOfItem);

		kb.close();// close scanner
	}// end start

	public static void denomination(float cents) {
		int centscastedToInt = (int) cents;
		int totalLeft = centscastedToInt % 2000;
		int twenties = centscastedToInt / 2000;

		if (twenties > 0) {
			System.out.println("Amount of twenties: " + twenties);
			//System.out.println("remainder after twenties:" + totalLeft);
		}
		if (totalLeft / 1000 >= 1) {
			int tens = totalLeft / 1000;
			totalLeft = totalLeft % 1000;
			System.out.println("Amount of Ten's: " + tens);
			//System.out.println("afte tens remainder is: " + totalLeft);
			// System.out.println("remainder is : " + remainder);
		}
		if (totalLeft / 500 >= 1) {
			int fives = totalLeft / 500;
			totalLeft = totalLeft % 500;
			if (fives > 0)
				System.out.println("Amount of fives: " + fives);
			//System.out.println("afte fives remainder is: " + totalLeft);
		}
		if (totalLeft / 100 >= 1) {
			int ones = totalLeft / 100;
			totalLeft = totalLeft % 100;
			System.out.println("Amount of ones: " + ones);
			//System.out.println("afte ones remainder is: " + totalLeft);
		}
		if (totalLeft / 25 >= 1) {
			int quarters = totalLeft / 25;
			totalLeft = totalLeft % 25;
			System.out.println("Amount of quarters: " + quarters);
			//System.out.println("afte quarters remainder is: " + totalLeft);
		}
		if (totalLeft / 10 >= 1) {
			int dimes = totalLeft / 10;
			totalLeft = totalLeft % 10;
			System.out.println("Amount of dimes: " + dimes);
			//System.out.println("afte dimes remainder is: " + totalLeft);
		}
		if (totalLeft / 5 >= 1) {
			int nickels = totalLeft / 5;
			totalLeft = totalLeft % 5;
			System.out.println("Amount of nickels: " + nickels);
			//System.out.println("afte nickels remainder is: " + totalLeft);
		}
		if (totalLeft / 1 >= 1) {
			int penny = totalLeft / 1;
			totalLeft = totalLeft % 1;
			System.out.println("Amount of pennies: " + penny);
			//System.out.println("afte pennies remainder is: " + totalLeft);
		}
	}

	public static float startTransaction(float price, float tender) {
		tender = tender * 100;
		price = price * 100;
		float diff = 0.0f;
		if (tender < price) {
			System.out.println("That is not enough silly, start over");
			start();// starts program over

		} else if (tender == price) {
			System.out.println("you get no change");
		} else {
			calc(tender, price);
			diff = tender - price;
			System.out.println("your change is: $" + diff / 100);
			// System.out.println("final use:" + diff); ***testing value***

		}
		return diff;
	}// end start transaction

	public static void denominations(float change) {
		System.out.println(change);
	}

	public static float calc(float tend, float pri) {
		float diff = (tend - pri) / 100;
		// System.out.println("your change is: " + diff);
		return diff;
	}

	public static float enterPrice(Scanner s) {
		System.out.println("Please enter the Price of the item: ");
		float itemPrice = s.nextFloat();
		return itemPrice;
	}// end enterPrice method

	public static String isThisCorrect(float price, Scanner s) {
		// System.out.println("You entered: " + price);
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
		}// end switch
		return price; // returns correct price after it's validated
	}// end verify method
		// how much did the customer give?

	public static float howMuchWasTendered(Scanner t) {
		System.out.print("How much did the customer give you?");
		float givenFromCustomer;
		givenFromCustomer = t.nextFloat();
		return givenFromCustomer;
	}// end "how much tendered" method

	public static float checkIfTenderedCorrect(String yesno, float checkGivenamount, Scanner yup) {
		// System.out.print("You entered: $" + checkGivenamount + "\nis this
		// correct? (Y/N)");
		// yup.next();
		switch (yesno) {
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
			checkGivenamount = yup.nextFloat();
			String newyesno = isThisCorrect(checkGivenamount, yup);
			checkIfTenderedCorrect(newyesno, checkGivenamount, yup);
			break;
		default:
			System.out.println("You need to enter a valid dollar amount");
			start();
			// String
		}// end switch statement
			// System.out.println(checkGivenamount);
		return checkGivenamount;
	}// end "check if tendered correct" method

}// end class
