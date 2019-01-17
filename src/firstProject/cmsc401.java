// @author Jeremy Bailey

package firstProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class cmsc401 {

	public static void main(String[] args) {
		
		//Start message
		System.out.println("Program start");
		
		//Scanner object created
		Scanner sc = new Scanner(System.in); 		
		
		//User input
		String str = sc.nextLine();
		
		//Finds what command char it is
		char commandChar = str.charAt(0);
		
		//Creates String array of user input, each element separated by a space
		String[] splited = str.split(" ");
		
		System.out.println(splited[0]);
		
		String A = splited[0];
		
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
		else if(commandChar == 'C') {
			
		}
		else {
			 System.out.println("if statement failed");
		}
		
//		System.out.println("Before: ");
//		// Prints out each individual element in array
//		for (int i = 0; i < nonIntNumbers.length; i++) {
//		    System.out.println(nonIntNumbers[i]);
//		}
//		
//		System.out.println("After: ");
//		// Prints out each individual element in array
//		for (int i = 0; i < numbers.length; i++) {
//		    System.out.println(numbers[i]);
//		}
		
	//	int y = x + 5;
		
//		System.out.println("x var " + y);
//		
//		System.out.println("splited 0 " + splited[0]);
//		
//		System.out.println("splited 3 " + splited[3]);
		
		System.out.println("Program complete");

	}
	
	public static void AproductCommand(int[] myArray) {
		int Product = 1;
		for (int i = 0; i < myArray.length; i++) {
	    if(myArray[i] != 0) {
	    	Product = myArray[i] * Product;
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

//// Prints out each individual element in array
//for (int i = 0; i < myArray.length; i++) {
//    System.out.println(myArray[i]);
//} 
