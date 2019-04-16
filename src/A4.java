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
		
		System.out.println(findMinCost(cuttingPoints, rodLength));
		
		//ex int cost = cr.cutRodToMinimizeCost(cuttingPoints, rodLength);
		
		input.close();

	}

	  private static int findMinCost(int[] markings, int len){
		    int[] logLen = logLen(markings, len);
		    int[][] dp = new int[markings.length+2][markings.length+2];
		    for(int betweenMarkCount = 1;
		        betweenMarkCount <= markings.length;
		        ++betweenMarkCount){
		      for(int i = 0;; ++i){
		        int j = i+betweenMarkCount+1;
		        if (j >= dp.length) break;
		        int min = Integer.MAX_VALUE;
		        int cost = logLen[j]-logLen[i];
		        for(int k = i+1; k <= j-1; ++k){
		          min = Math.min(min, dp[i][k]+dp[k][j]+cost);
		        }
		        dp[i][j] = min;
		      }
		    }
		    return dp[0][dp.length-1];
		  }
		  private static int[] logLen(int[] markings, int len){
		    int[] ret = new int[markings.length+2];
		    for(int i = 1; i <= markings.length; ++i){
		      ret[i] = markings[i-1];
		    }
		    ret[ret.length-1] = len;
		    return ret;
		  }

}




