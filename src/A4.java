import java.util.Arrays;
import java.util.Scanner;

/** @author Jeremy Bailey
 * 
 */

public class A4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter length of rod: " );
		
		int rodLength = input.nextInt();
		
		System.out.println("Enter number of cutting points: " );
		
		int numberOfCuttingPoints = input.nextInt();
		
		int cuttingPoints[] = new int[numberOfCuttingPoints];
		int i = 0;
		
		System.out.println("Enter the points that will be cut: ");
		while(input.hasNextInt()) {
			 cuttingPoints[i] = input.nextInt(); 
			 i++;
			 if(i == numberOfCuttingPoints)
				 break;
		}
		Arrays.sort(cuttingPoints);
		System.out.println(Arrays.toString(cuttingPoints));
		
		//ex int cost = cr.cutRodToMinimizeCost(cuttingPoints, rodLength);
		
		input.close();
		
		
		
		
		
		
	}

}




