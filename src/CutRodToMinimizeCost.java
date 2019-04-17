
/**
 * Date 07/20/2015
 * @author Tushar Roy
 *
 * Given a rod with markings. Cut the rod along markings but reduce the cost of cutting.
 * Cost if cutting is proportional to the length of rod being cut.
 *
 * Solve is using top down dynamic programming. Memoize minimum cost of cutting between marking
 * start to end. To calculate the value try all markings b/w start to end.
 *
 */
public class CutRodToMinimizeCost {


    public int cutRodToMinimizeCost(int [] markings, int total) {
        int T[][] = new int[total+2][total+2]; //Create 2D square array.
        for(int i = 0 ; i < T.length; i++) {
            for(int j=0; j < T[i].length ; j++) {
                T[i][j] = -1;  //Place -1 as placeholder for every element in 2D square array
            }
        }
//        System.out.println("line 24 cutRodToMinimizeCost: " + );
        return cutRodToMinimizeCost(markings, 0, total, T);
    }

    private int cutRodToMinimizeCost(int[] markings, int start, int end, int T[][]){

        if(T[start][end] != -1) {
        	
    //    	System.out.println("Line 29 if statement return T[start][end]: " + T[start][end]);
            return T[start][end];
        }

        int i;
        for(i=0; i < markings.length; i++){
            if(start < markings[i]) {
                break;
            }
        }
        if(i == markings.length) {
            T[start][end] = 0;
            return 0;
        }
        
        int j;
        for(j=markings.length -1; j >= 0; j--){
            if(end > markings[j]) {
                break;
            }
        }
        if(j == -1) {
            T[start][end] = 0;
            return 0;
        }
        if(i == j){
            T[start][end] = end - start;
           // System.out.println("if statement on line 57 return end - start: " + (end - start));
            return end - start;
        }
        int cost = end - start;
      //  System.out.println("Line 61 cost: " + cost);
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k <= j; k++) {
            int c1 = cutRodToMinimizeCost(markings, start, markings[k], T);
            int c2 = cutRodToMinimizeCost(markings, markings[k], end, T);
            if(c1 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE) {
                continue;
            }
            if(minCost > c1 + c2){
                minCost = c1 + c2;
            }
        }
        if(minCost == Integer.MAX_VALUE) {
            T[start][end] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        T[start][end] = cost + minCost;
   //   System.out.println("Current cost: " + cost);
   //   System.out.println("Current minCost: " + minCost);
   //   System.out.println("Line 77 return cost + minCost: " + (cost + minCost));
        return cost + minCost;
    }
    
    public static void main(String args[]) {
        int markings[] = {1,5,7,9};
        CutRodToMinimizeCost cr = new CutRodToMinimizeCost();
        int cost = cr.cutRodToMinimizeCost(markings, 10);
        System.out.println(cost);       
        
        // 100, 6, 17, 23, 36, 69, 72, 83 ... answer should be 264
    }
}
