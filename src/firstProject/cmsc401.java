// @author Jeremy Bailey

package firstProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cmsc401 {

	public static void main(String[] args) {
		
		boolean persist = true;
		char commandChar;
		
		//Start message
		System.out.println("Program start");
		
		//Scanner object created
		Scanner sc = new Scanner(System.in); 		
		
		while(sc.hasNextLine() && persist) {

		System.out.println(" ");
		
		//User input
		String str = sc.nextLine();
		
		if(str != null && !str.isEmpty()) {
			//Finds what command char it is
			commandChar = str.charAt(0);
		}
		else {
			commandChar = 'z';
		}
		
		//Creates String array of user input, each element separated by a space
		String[] splited = str.split(" ");
		
		//Creates String array without command character
		String[] nonIntNumbers = Arrays.copyOfRange(splited, 1, splited.length);
		
		//Creates int array same length of nonIntNumbers
		int[] numbers = new int[nonIntNumbers.length];
		
		//Converts elements in "nonIntNumbers" array to ints.
		//Adds int elements to "numbers" array
		for(int i = 0;i < nonIntNumbers.length;i++)
		{
		   numbers[i] = Integer.parseInt(nonIntNumbers[i]);
		}
		
		if(commandChar == 'A') {
			System.out.println("command A detected");
			AproductCommand(numbers);
		}
		else if(commandChar == 'B') {
			System.out.println("command B detected");
			BfactorialCommand(numbers);
		}
		else {
			 System.out.println("if statement failed");
			 persist = false;
		}
		}

		System.out.println(" ");
		System.out.println("Program complete");

	}

	public static void AproductCommand(int[] myArray) {
		int Product = 1;
		int startIndex = myArray[myArray.length - 2];
		int endIndex = myArray[myArray.length - 1];
		int[] terms = Arrays.copyOfRange(myArray, 0, myArray.length - 2);

		for (int i = startIndex - 1; i < endIndex ; i++) {
	    if(terms[i] != 0) {
	    	Product = terms[i] * Product;
	    	};
	    	
	    };
	    int finalProduct = Product;
	    System.out.println(finalProduct);
	}; 
	
	public static void BfactorialCommand(int[] myArray) {

		int num = myArray[0];
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            factorial *= i;
        }
        
        System.out.println(factorial);
	
	}
	

}


//System.out.println(splited[0]);

//String A = splited[0];

//// Prints out each individual element in array
//for (int i = 0; i < terms.length; i++) {
//    System.out.println(terms[i]);
//} 
//System.out.println("array length " + myArray.length);
//System.out.println("endIndex is " + endIndex);
//System.out.println("startIndex is " + startIndex);


//System.out.println("Before: ");
//// Prints out each individual element in array
//for (int i = 0; i < nonIntNumbers.length; i++) {
//    System.out.println(nonIntNumbers[i]);
//}
//
//System.out.println("After: ");
//// Prints out each individual element in array
//for (int i = 0; i < numbers.length; i++) {
//    System.out.println(numbers[i]);
//}

//	int y = x + 5;

//System.out.println("x var " + y);
//
//System.out.println("splited 0 " + splited[0]);
//
//System.out.println("splited 3 " + splited[3]);

//// Prints out each individual element in array
//for (int i = 0; i < myArray.length; i++) {
//    System.out.println(myArray[i]);
//} 
