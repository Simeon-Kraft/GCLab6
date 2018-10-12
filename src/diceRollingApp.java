import java.util.Scanner;
import java.util.Random;

public class diceRollingApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String goAgain = null;

		do {
			System.out.println("Let's gamble! How many sides should each die have?");
			String diceString = scnr.next();
			while (isNumber(diceString) == false) {
				System.out.println("That's not a number, cheater. Try again: ");
				diceString = scnr.next();
			}

			while (nonZero(diceString) == false) {
				System.out.println("There's no such thing as a zero sided die. Try again: ");
				diceString = scnr.next();
			}
			
			int diceSides = Integer.parseInt(diceString);
			int left = generateRandomDiceRoll(diceSides);
			int right = generateRandomDiceRoll(diceSides);

			System.out.println("Here we go...");

			if (left + right == 2) {
				System.out.println(left + " and " + right + ". Snake-eyes, sucka!");
			}

			else if (left + right == 12) {
				System.out.println(left + " and " + right + "! Boxcars, lucky-ducky!");
			}

			else if (left + right == 7) {
				System.out.println(left + " and " + right + "! Craps!");
			} else {
				System.out.println("You rolled " + left + " and " + right + ".");
			}

			System.out.println("Wanna go roll again? (y/n)");
			goAgain = scnr.next();
		} while (goAgain.equalsIgnoreCase("y"));

		System.out.println("Tired of losing money, are we?");
	}

	private static int generateRandomDiceRoll(int upperTheshholdFromOne) {
		Random rand = new Random();
		if (upperTheshholdFromOne == 1) {
			return 1;
		}
		
		int upperThreshZero = upperTheshholdFromOne - 1;
		int adjustedRand = rand.nextInt(upperThreshZero);
		
		return adjustedRand + 1;
		
	}

	public static boolean isNumber(String str) {

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			boolean charIsDigit;
			charIsDigit = Character.isDigit(currentChar);
			if (charIsDigit == false) {
				return false;
			}

		}
		return true;
	}
	
	public static boolean nonZero(String str) {
		
		if (Integer.parseInt(str) == 0) {
			return false;
		}
		return true;
	}

}
