
public class assignment4 {
	
	
	 public int cutRodToMinimizeCost(int [] markings, int total) {
	        int TotalRod[] = new int[total+1]; 
	    

	        return 404;
	    }
	
	
	
    public static void main(String args[]) {
        int markings[] = {1,5,7,9};
        CutRodToMinimizeCost cr = new CutRodToMinimizeCost();
        int cost = cr.cutRodToMinimizeCost(markings, 10);
        System.out.println(cost);       
        
        // 100, 6, 17, 23, 36, 69, 72, 83 ... answer should be 264
    }

}
