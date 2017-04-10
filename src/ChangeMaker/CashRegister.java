package ChangeMaker;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		start(); // <--- Aaron taught me this!!

	}// end main

	public static void start() {
		Scanner kb = new Scanner(System.in);

		float checkedPriceOfItem = priceinputAndCheckIt(kb);

		float checkedTender = tenderInputAndCheckIt(kb);

		// method to convert amount into pennies to make it easier to work with
		float penniesOwed = startTransaction(checkedPriceOfItem, checkedTender);

		calculateDenominations(penniesOwed);

		// System.out.println("final is: " + penniesOwed); //testing my result
		kb.close();// close scanner
	}// end start

	public static float tenderInputAndCheckIt(Scanner kb) {
		float tendered = howMuchWasTendered(kb);

		String tenderedYesorNo = isThisCorrect(tendered, kb);

		float checkedTender = checkIfTenderedCorrect(tenderedYesorNo, tendered, kb);
		return checkedTender;

	}

	public static float priceinputAndCheckIt(Scanner kb) {
		float priceOfItem = enterPrice(kb);// asks for price and stores it in
											// variable
		String priceYesOrNo = isThisCorrect(priceOfItem, kb);// asks customer if
		// price is correct and
		// keeps looping until
		// customer says yes
		float checkedPriceOfItem = verify(priceYesOrNo, priceOfItem, kb);// stores
																			// correct
		return checkedPriceOfItem; // price
		// in variable
	}// end priceinputAndCheckIt method

	//Each method runs and sets the remainder equal to the next method underneath it
	public static void calculateDenominations(float cents) {
		int centscastedToInt = (int) cents;		
		int TotalLeft = centscastedToInt;
		int newTotalLeft;
		newTotalLeft = doMathForEachDenominationCalculation(TotalLeft, "Twenties", 2000);
		newTotalLeft = doMathForEachDenominationCalculation(newTotalLeft, "Tens", 1000);
		newTotalLeft = doMathForEachDenominationCalculation(newTotalLeft, "fives", 500);
		newTotalLeft = doMathForEachDenominationCalculation(newTotalLeft, "Ones", 100);
		newTotalLeft = doMathForEachDenominationCalculation(newTotalLeft, "quarters", 25);
		newTotalLeft = doMathForEachDenominationCalculation(newTotalLeft, "dimes", 10);
		newTotalLeft = doMathForEachDenominationCalculation(newTotalLeft, "nickels", 5);
		newTotalLeft = doMathForEachDenominationCalculation(newTotalLeft, "pennies", 1);
		
	}// end calcDenominations method

	public static int doMathForEachDenominationCalculation(int totalLeft, String denominationType, int divisor) {
		if (totalLeft / divisor >= 1) {
			int denom = totalLeft / divisor;
			totalLeft = totalLeft % divisor;
			System.out.println("Amount of " + denominationType + " : " + denom);
		}
		return totalLeft;
	}// end doMathforeach method

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
		// System.out.println("your change is: " + diff); // testing value
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
		if ((yesOrNo.equals("Y") || yesOrNo.equals("y") || yesOrNo.equals("Yes") || yesOrNo.equals("yes"))) {

		} else if ((yesOrNo.equals("N") || yesOrNo.equals("n") || yesOrNo.equals("No") || yesOrNo.equals("no"))) {
			price = priceinputAndCheckIt(s);
			return price;
		} else {
			System.out.print("That is in invalid answer, Please select (Y/N): ");
			isThisCorrect(price, s);
		}
		return price;
	}

	public static float howMuchWasTendered(Scanner t) {
		System.out.print("How much did the customer give you?");
		float givenFromCustomer;
		givenFromCustomer = t.nextFloat();
		return givenFromCustomer;
	}// end "how much tendered" method

	public static float checkIfTenderedCorrect(String yesNo, float checkGivenamount, Scanner yup) {
		if ((yesNo.equals("Y") || yesNo.equals("y") || yesNo.equals("Yes") || yesNo.equals("yes"))) {

		} else if ((yesNo.equals("N") || yesNo.equals("n") || yesNo.equals("No") || yesNo.equals("no"))) {
			checkGivenamount = tenderInputAndCheckIt(yup);

		} else {
			System.out.print("That is in invalid answer, Please select (Y/N): ");
			isThisCorrect(checkGivenamount, yup);
		}
		return checkGivenamount;

	}// end "check if tendered correct" method

}// end class
