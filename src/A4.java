import java.util.Arrays;
import java.util.Scanner;

/** @author Jeremy Bailey
 *  Sources: careercup
 */

public class A4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Separate input into separate function
		getProblemInfo();

	}
	
	private static void getProblemInfo() {
		
		//Create scanner object to accept input
		Scanner input = new Scanner(System.in);
		
		//System.out.println("Enter length of rod: " );
		
		//first input will be length of the rod
		int rodLength = input.nextInt();
		
		//System.out.println("Enter number of cutting points: " );
		
		//Second input will be the number of points that will be cut
		int numberOfCuttingPoints = input.nextInt();
		
		//initialize array to length of number of cutting points
		int cuttingPoints[] = new int[numberOfCuttingPoints];
		
		int i = 0;
		
		//System.out.println("Enter the points that will be cut: ");
		
		//Third input will be the actual points that need to be cut
		while(input.hasNextInt()) {
			 cuttingPoints[i] = input.nextInt(); 
			 i++;
			 if(i == numberOfCuttingPoints)
				 break;
		}
		
		//Sort array
		 Arrays.sort(cuttingPoints);
		
		//Print out value that minimumCostToCut returns, passing in cuttingPoints and rodLength
		System.out.println(minimumCostToCut(cuttingPoints, rodLength));

		//Close I/O stream of input
		input.close();
	}

	  
	  //Returns array of markings with original length of array + 1 with len appended on to end
	  private static int[] lengthOfRod(int[] markings, int len){
	   
		 //Define array that will have all marks and total length
		 int[] lengthOfRod = new int[markings.length+2];
	    
		 //Iterate through markings until all elements have been added to lengthOfRod
		 for(int i = 1; i <= markings.length; ++i){
			 
	      lengthOfRod[i] = markings[i-1];
	    }
		 //Append total length of rod to end of array
		 lengthOfRod[lengthOfRod.length-1] = len;
	    
		 //Returns array of markings with original length of array + 1 with length appended
		 return lengthOfRod;
	  }

	  //Function that will calculate minimum cost for cuts
	  private static int minimumCostToCut(int[] cutMarks, int len){
		    
		  //Create lengthOfRod by lengthOfRod function
		  int[] lengthOfRod = lengthOfRod(cutMarks, len);
		    
		  	//Initialize 2d array that will be used to memoize computed values. Make matrix the length of the cutMarks + 2
		    int[][] memoizedValues = new int[cutMarks.length+2][cutMarks.length+2];
		    
		//Iterate through rodSegments until rodSegments have checked all cutMarks, completing inner for loops
		for(int rodSegments = 1; rodSegments <= cutMarks.length; ++rodSegments){
		    
		    //Iterate through rodSegments until j is at least as big as the length of memoizedValues 
		    for(int i = 0;; ++i){
		        
		    	//Initialize j 
		    	int j = i+rodSegments+1;
		        
		    	//If we are outside the memoizedValue 2d array length, break out of for loop
		    	if (j >= memoizedValues.length) {
		        	break;
		        }
		        
		    	//Set minimumCut to infinite 
		        int minimumCut = Integer.MAX_VALUE;
		        
		        //Set cutCost to length distance at j minus i in lengthOfRod array
		        int cutCost = lengthOfRod[j]-lengthOfRod[i];
			
		        //Iterate through memoized values to check if better minimum cost exists
		        for(int k = i+1; k <= j-1; ++k){
		        	
		        	//Check if value at matrix locations for lowest value
		        	if(memoizedValues[i][k]+memoizedValues[k][j]+cutCost < minimumCut) {
		        		minimumCut = memoizedValues[i][k]+memoizedValues[k][j]+cutCost;
		        	}
		        	
		        }
		        //Set value [i][j] in matrix to minimumCut
		        memoizedValues[i][j] = minimumCut;
		      }
		      
		    }
		    //Returns smallest total cut cost
		    return memoizedValues[0][memoizedValues.length-1];
		  }

}




