// @author Jeremy Bailey

package firstProject;

import java.util.Scanner;

public class cmsc401 {

	public static void main(String[] args) {
		
		//Start message
		System.out.println("Program start");
		
		//Scanner object created
		Scanner sc = new Scanner(System.in); 		
		
		//User input
		String str = sc.nextLine();
		
		//Creates String array of user input, each element separated by a space
		String[] splited = str.split(" ");
		
		System.out.println(splited[0]);
		
		if(splited[0] == "4") {
			System.out.println("If statement succeed");
		}
		else {
			 System.out.println("If statement failed");
		}
		
//		switch(splited[0]) {
//		
//			case "A": {
//				AproductCommand(splited);
//			}
//		
//			case "B": {
//				int x = Integer.parseInt(splited[1]);
//				BfactorialCommand(x);
//			}
//		}
		
//		//Creates int array same length of splited array
//		int[] numbers = new int[splited.length];
//		
//		//Converts elements in "splited" array to ints.
//		//Adds int elements to "numbers" array
//		for(int i = 0;i < splited.length;i++)
//		{
//		   numbers[i] = Integer.parseInt(splited[i]);
//		}
//
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
	
	public static void AproductCommand(String[] splited) {
		
		// Prints out each individual element in array
				for (int i = 0; i < splited.length; i++) {
				    System.out.println(splited[i]);
				} 
		int finaProduct;
		System.out.println();
	}
	
	public static void BfactorialCommand(int x) {

		int num = x;
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            factorial *= i;
        }
        
        System.out.println(factorial);
	
	}
	

}
