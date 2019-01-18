// @author Jeremy Bailey

package firstProject;

import java.util.Arrays;
import java.util.Scanner;

public class cmsc401 {

	public static void main(String[] args) {

		boolean persist = true;
		char commandChar;

		// Start message
		// System.out.println("Program start");

		// Scanner object created
		Scanner sc = new Scanner(System.in);

		// Continues computing until no command character is given
		while (sc.hasNextLine() && persist) {

			// System.out.println(" ");

			// User input
			String str = sc.nextLine();

			if (str != null && !str.isEmpty()) {
				// Finds what command char it is
				commandChar = str.charAt(0);
			} else {
				commandChar = 'z';
			}

			// Creates String array of user input, each element separated by a space
			String[] splited = str.split(" ");

			// Creates String array without command character
			String[] nonIntNumbers = Arrays.copyOfRange(splited, 1, splited.length);

			// Creates int array same length of nonIntNumbers
			int[] numbers = new int[nonIntNumbers.length];

			// Converts elements in "nonIntNumbers" array to ints.
			// Adds int elements to "numbers" array
			for (int i = 0; i < nonIntNumbers.length; i++) {
				numbers[i] = Integer.parseInt(nonIntNumbers[i]);
			}

			if (commandChar == 'A') {
				// System.out.println("command A detected");
				AproductCommand(numbers);
			} else if (commandChar == 'B') {
				// System.out.println("command B detected");
				BfactorialCommand(numbers);
			} else {
				// System.out.println("if statement failed");
				persist = false;
			}
		}

		// System.out.println(" ");
		// System.out.println("Program complete");

	}
	//Computes A command from startIndex to endIndex ignoring any zeros
	public static void AproductCommand(int[] myArray) {
		int Product = 1;
		int startIndex = myArray[myArray.length - 2];
		int endIndex = myArray[myArray.length - 1];
		int[] terms = Arrays.copyOfRange(myArray, 0, myArray.length - 2);

		for (int i = startIndex - 1; i < endIndex; i++) {
			if (terms[i] != 0) {
				Product = terms[i] * Product;
			}
			;

		}
		;
		int finalProduct = Product;
		System.out.println(finalProduct);
	};
	
	//Computes B command by giving factorial
	public static void BfactorialCommand(int[] myArray) {

		int num = myArray[0];
		long factorial = 1;
		for (int i = 1; i <= num; ++i) {
			factorial *= i;
		}

		System.out.println(factorial);

	}

}
